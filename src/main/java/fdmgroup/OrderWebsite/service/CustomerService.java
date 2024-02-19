package fdmgroup.OrderWebsite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.CustomerOrder;
import fdmgroup.OrderWebsite.repository.CustomerRepository;
import fdmgroup.OrderWebsite.repository.OrderRepository;

/**
 * The CustomerService class provides business logic for managing customer-related operations.
 * It interacts with the CustomerRepository to perform CRUD (Create, Read, Update, Delete) operations.
 * @author = Danny
 */

@Service("customerService")
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	private static final Logger log = LogManager.getLogger(CustomerService.class);
	
	 /**
     * Registers a new customer in the system.
     * @param customer The Customer object to be registered.
     * @return true if the registration is successful, false if a customer with the same ID already exists.
     */
	public boolean registerNewCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(customer.getUsername());
		
		if (customerOptional.isEmpty()) {
			customerRepo.save(customer);
			log.info("SaveSuccess: customer with id " + customer.getCustomerId() + "saved to Customer");
			return true;
		} else {
			log.error("RegistrationFailure: Registration failed as "+ customer.getUsername() + "already exists");
			return false;
		}
	}
	
	/**
     * Retrieves a customer based on the provided customer ID.
     * @param customerID The ID of the customer to be retrieved.
     * @return The Customer object associated with the given ID, or a default customer if not found.
     */
	public Customer findCustomer(int customerID) {
		Optional<Customer> customerOptional = customerRepo.findById(customerID);
		Customer customer = customerOptional.orElse(new Customer("defaultName","defaultPassword"));
		return customer;
	}

	 /**
     * Retrieves a list of all customers in the system.
     * @return A List of Customer objects representing all registered customers.
     */
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		log.info("RetrievalSuccess: List of customers found");
		return customerRepo.findAll();
	}

	/**
     * Verifies customer credentials by checking the provided username and password.
     * @param username The username of the customer.
     * @param password The password of the customer.
     * @return true if the credentials are valid, false otherwise.
     */
	public boolean verifyCustomerCredientials(String username, String password) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if (customerOptional.isEmpty()) {
			log.error("RegistrationFailure: Incorrect username or password entered");
			return false;
		}else {
			log.info("LoginInfo: Correct username entered.");
			return customerOptional.get().getPassword().equals(password);
		}
	}
	
	/**
     * Retrieves customer based on the provided username.
     * @param username The username of the customer to be retrieved.
     * @return The Customer object associated with the given username, or a default if not found.
     */
	public Customer findCustomerByUsername(String username) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		Customer customer = customerOptional.orElse(new Customer("defaultName","defaultPassword"));
		log.info("RetrievalSuccess: customer with username " + username + " found");
		return customer;
	}
	
	/**
     * Retrieves customer's order based on the provided username.
     * @param username The username of the customer to be retrieved.
     * @return The list of order associated with the given username, or an empty list if not found.
     */
	public List<CustomerOrder> getOrderByUsername(String username){
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if (!customerOptional.isEmpty()) {
			Customer customer = customerOptional.get();
			return orderRepo.findAllByCustomer(customer);
		}else {
			log.info("RetrievalNull: Empty list of customers retrieved as there are no orders made by customer with username " + username + ".");
			return new ArrayList<CustomerOrder>();
		}
	}
}
