package fdmgroup.OrderWebsite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.CustomerOrder;
import fdmgroup.OrderWebsite.service.CustomerService;
import fdmgroup.OrderWebsite.service.DrinkService;
import fdmgroup.OrderWebsite.service.OrderService;
import fdmgroup.OrderWebsite.service.ToppingService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private ToppingService toppingService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String goToIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String goToLogin() {
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String goToRegister(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	@GetMapping("/menu")
	public String goToMenu(Model model) {
		model.addAttribute("drinks", drinkService.getAllDrinks());
		model.addAttribute("toppings",toppingService.getAllToppings());
		return "menu";
	}

	
	@PostMapping("/register")
	public String userRegistration(@Validated Customer customer, BindingResult bindingResult, Model model) {		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		//Save to Database
		if (customerService.registerNewCustomer(customer)) {
			model.addAttribute("confirmationMessage", "Registration successful! You may log in now");
			return "confirmation";
		} else {
			model.addAttribute("errorMessage", "Registration failed as " + customer.getUsername()+ " already existed. Please try another username.");
			return "register";
		}
	}
	
	@PostMapping("/login")
	public String verifyUser(@RequestParam String username, @RequestParam String password, HttpSession session,Model model) {
		if(customerService.verifyCustomerCredientials(username,password)) {
			session.setAttribute("current_user", username);
			Customer customer = customerService.findCustomerByUsername(username);
			session.setAttribute("customer", customer);
			model.addAttribute("customer",customer);
			List<CustomerOrder> orders = customer.getOrders();
		    model.addAttribute("orders",orders);
			return "home";
		}else {
			model.addAttribute("errorMessage", "Incorrect username or password. Please try again.");
			System.err.println("Incorrect username or password");
			return "redirect:/";
		}
	}
	
	@Primary
	@GetMapping("/home")
	public String customerHomePage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_user");
		
		if(username.equals(null)|| username.isEmpty()) {
			return "redirect:/";
		}
		Customer customer = customerService.findCustomerByUsername(username);
		session.setAttribute("customer", customer);
		model.addAttribute("customer", customer);
		List<CustomerOrder> orders = customer.getOrders();
	    model.addAttribute("orders",orders);
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/order")
    public String showOrderPage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_user");
		Customer customer = customerService.findCustomerByUsername(username);
        model.addAttribute("customer", customer);
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("toppings", toppingService.getAllToppings());
        model.addAttribute("order", new CustomerOrder());
        return "order";
    }
	
	 @PostMapping("/home")
	 public String placeOrder(HttpSession session,@Validated CustomerOrder order, BindingResult bindingResult, Model model) {
		 String username = (String) session.getAttribute("current_user");
		 customerService.findCustomerByUsername(username);
		 if (bindingResult.hasErrors()) {
			 return "order";
	        }
		 if (orderService.addOrderToCustomer(username, order)) {
				model.addAttribute("confirmationMessage", "CustomerOrder placed successfully!");
				return "orderConfirmation";
			} else {
				model.addAttribute("errorMessage", "CustomerOrder failed.");
				return "order";
			}
	    }
	 
	 @GetMapping("/orderConfirmation")
	 public String goToOrderConfirmation() {
			return "/home";
		}

}
