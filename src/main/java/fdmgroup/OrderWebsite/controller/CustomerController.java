package fdmgroup.OrderWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.service.CustomerService;
import fdmgroup.OrderWebsite.service.DrinkService;
import fdmgroup.OrderWebsite.service.OrderRecipeService;
import fdmgroup.OrderWebsite.service.OrderService;
import fdmgroup.OrderWebsite.service.RecipeService;
import fdmgroup.OrderWebsite.service.ToppingService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private OrderRecipeService orderRecipeService;
	
	@Autowired
	private ToppingService toppingService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String goToIndex() {
		return "index";
	}
	
	@GetMapping("/register")
	public String goToRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegistration(Customer customer) {		
		//Save to Database
		if (customerService.registerNewCustomer(customer)) {
			// Inform user
			return "redirect:/";
		} else {
			return "register";
		}
	}
	
	@PostMapping("/")
	public String verifyUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
		if(customerService.verifyCustomerCredientials(username,password)) {
			session.setAttribute("current_user", username);
			return "home";
		}else {
			return "/";
		}
	}
	
	@GetMapping("/home")
	public String userHomePage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_user");
		Customer customer = customerService.findCustomerByUsername(username);
		model.addAttribute("customer",customer);
		return "redirect:/home";
	}
}
