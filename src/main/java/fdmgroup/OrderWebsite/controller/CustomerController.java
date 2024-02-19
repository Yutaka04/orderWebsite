package fdmgroup.OrderWebsite.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import fdmgroup.OrderWebsite.service.MenuService;
import fdmgroup.OrderWebsite.service.OrderService;
import fdmgroup.OrderWebsite.service.ToppingService;
import jakarta.servlet.http.HttpSession;

/**
 * Controller class for handling customer-related operations such as registration, login, and order placement.
 * Uses Spring MVC annotations for request mapping.
 * @author = danny
 */

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
	
	@Autowired
	private MenuService menuService;
	
	private static final Logger log = LogManager.getLogger(CustomerController.class);
	
	/**
     * Redirects to the index page.
     * @return String representing the view name ("index").
     */
	@GetMapping("/")
	public String goToIndex() {
		menuService.initialiseMenu();
		return "index";
	}
	
    /**
     * Redirects to the login page.
     * @return String representing the view name ("index").
     */
	@GetMapping("/login")
	public String goToLogin() {
		return "redirect:/";
	}
	
	/**
     * Redirects to the register page with an empty customer model.
     * @param model the Spring MVC model.
     * @return String representing the view name ("register").
     */
	@GetMapping("/register")
	public String goToRegister(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
    /**
     * Redirects to the menu page with the list of drinks and toppings.
     * @param model the Spring MVC model.
     * @return String representing the view name ("menu").
     */
	@GetMapping("/menu")
	public String goToMenu(Model model) {
		model.addAttribute("drinks", drinkService.getAllDrinks());
		model.addAttribute("toppings",toppingService.getAllToppings());
		return "menu";
	}


    /**
     * Handles user registration by saving the customer to the database.
     * @param customer       the customer entity to be registered.
     * @param bindingResult  the Spring MVC binding result for validation.
     * @param model          the Spring MVC model.
     * @return String representing the view name ("confirmation" or "register").
     */
	@PostMapping("/register")
	public String userRegistration(@Validated Customer customer, BindingResult bindingResult, Model model) {		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		//Save to Database
		if (customerService.registerNewCustomer(customer)) {
			model.addAttribute("confirmationMessage", "Registration successful! You may log in now");
			log.info("RegistrationSuccess: " + customer.getUsername() + " created.");
			return "confirmation";
		} else {
			model.addAttribute("errorMessage", "Registration failed as " + customer.getUsername()+ " already existed. Please try another username.");
			log.error("RegistrationError: " + customer.getUsername() + " already exist");
			return "register";
		}
	}
	
	
    /**
     * Handles user login, sets session attributes, and redirects to the home page.
     * @param username       the entered username.
     * @param password       the entered password.
     * @param session        the HTTP session.
     * @param model          the Spring MVC model.
     * @return String representing the view name ("home" or "index").
     */
	@PostMapping("/login")
	public String verifyUser(@RequestParam String username, @RequestParam String password, HttpSession session,Model model) {
		if(customerService.verifyCustomerCredientials(username,password)) {
			log.info("SessionSuccess: User session with username " + username + " obtained.");
			session.setAttribute("current_user", username);
			log.info("SetAttributeSuccess: " + username + " set to current_user");
			Customer customer = customerService.findCustomerByUsername(username);
			log.info("RetrivalSuccess: Customer with username " + username + " retrieved.");
			session.setAttribute("customer", customer);
			log.info("SetAttributeSuccess: Customer with username " + username + " set.");
			model.addAttribute("customer",customer);
			log.info("AddAttributeSuccess: Customer with username " + username + " added to session.");
			List<CustomerOrder> orders = customer.getOrders();
			log.info("RetrivalSuccess: Order of customer with username " + username + " retrieved.");
		    model.addAttribute("orders",orders);
		    log.info("AddAttributeSuccess: Customer with username " + username + " added to session.");
			return "home";
		}else {
			model.addAttribute("errorMessage", "Incorrect username or password. Please try again.");
			log.error("LoginError: Password entered did not match.");
			return "index";
		}
	}
	
	/**
	 * Handles requests to display the customer's home page, including past orders.
	 * @param session the HTTP session.
	 * @param model   the Spring MVC model.
	 * @return String representing the view name ("home" or "redirect:/").
	 */
	
	@Primary
	@GetMapping("/home")
	public String customerHomePage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_user");
		log.info("SessionRetrivalSuccess: User session with username " + username + " retrieved.");
		if(username.equals(null)|| username.isEmpty()) {
			return "redirect:/";
		}
		Customer customer = customerService.findCustomerByUsername(username);
		log.info("RetrivalSuccess: Customer with username " + username + " retrieved.");
		session.setAttribute("customer", customer);
		log.info("SetAttributeSuccess: Customer with username " + username + " set.");
		model.addAttribute("customer", customer);
		log.info("AddAttributeSuccess: Customer with username " + username + " added to session.");
		List<CustomerOrder> orders = customer.getOrders();
		log.info("RetrivalSuccess: Order of customer with username " + username + " retrieved.");
	    model.addAttribute("orders",orders);
	    log.info("AddAttributeSuccess: Customer with username " + username + " added to session.");
		return "home";
	}
	
	/**
	 * Handles user logout by invalidating the session.
	 * @param session the HTTP session.
	 * @return String representing the view name ("redirect:/").
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		String username = (String) session.getAttribute("current_user");
		log.info("LogOutSuccess: customer of with username" + username + " has successfully logged out.");
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * Handles requests to display the order page with drink and topping options.
	 * @param session the HTTP session.
	 * @param model   the Spring MVC model.
	 * @return String representing the view name ("order").
	 */
	@GetMapping("/order")
    public String showOrderPage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("current_user");
		Customer customer = customerService.findCustomerByUsername(username);
        model.addAttribute("customer", customer);
        log.info("AddAttributeSuccess: Customer with username " + username + " added to session.");
        model.addAttribute("drinks", drinkService.getAllDrinks());
        log.info("AddAttributeSuccess: Current Drink Menu added to session.");
        model.addAttribute("toppings", toppingService.getAllToppings());
        log.info("AddAttributeSuccess: Current Topping Menu added to session.");
        model.addAttribute("order", new CustomerOrder());
        log.info("AddAttributeSuccess: new Order Class added to session.");
        return "order";
    }
	
	/**
	 * Handles the placement of a customer order.
	 * @param session        the HTTP session.
	 * @param order          the customer order to be placed.
	 * @param bindingResult  the Spring MVC binding result for validation.
	 * @param model          the Spring MVC model.
	 * @return String representing the view name ("orderConfirmation" or "order").
	 */
	 @PostMapping("/home")
	 public String placeOrder(HttpSession session,@Validated CustomerOrder order, BindingResult bindingResult, Model model) {
		 String username = (String) session.getAttribute("current_user");
		 customerService.findCustomerByUsername(username);
		 if (bindingResult.hasErrors()) {
			 return "order";
	        }
		 if (orderService.addOrderToCustomer(username, order)) {
				model.addAttribute("confirmationMessage", "CustomerOrder placed successfully!");
				log.info("AddAttributeSuccess: Order Id of" + order.getOrderId() + " added to customer with username " + username + ".");
				return "orderConfirmation";
			} else {
				model.addAttribute("errorMessage", "CustomerOrder failed.");
				log.error("OrderError: Unable to add order.");
				return "order";
			}
	    }
	 
	 /**
	  * Handles requests to display the order confirmation page.
	  * @return String representing the view name ("redirect:/home").
	  */
	 @GetMapping("/orderConfirmation")
	 public String goToOrderConfirmation() {
			return "/home";
		}

}
