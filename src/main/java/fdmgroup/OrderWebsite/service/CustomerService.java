package fdmgroup.OrderWebsite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.Order;
import fdmgroup.OrderWebsite.repository.CustomerRepository;
import fdmgroup.OrderWebsite.repository.OrderRepository;

/**
 * The CustomerService class provides business logic for managing customer-related operations.
 * It interacts with the CustomerRepository to perform CRUD (Create, Read, Update, Delete) operations.
 * @author = Danny
 */

public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	 /**
     * Registers a new customer in the system.
     * @param customer The Customer object to be registered.
     * @return true if the registration is successful, false if a customer with the same ID already exists.
     */
	public boolean registerNewCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepo.findById(customer.getCustomerId());
		
		if (customerOptional.isEmpty()) {
			customerRepo.save(customer);
			return true;
		} else {
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
			return false;
		}else {
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
		return customer;
	}
	
	/**
     * Retrieves customer's order based on the provided username.
     * @param username The username of the customer to be retrieved.
     * @return The list of order associated with the given username, or an empty list if not found.
     */
	public List<Order> getOrderByUsername(String username){
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if (customerOptional.isEmpty()) {
			Customer customer = customerOptional.get();
			return orderRepo.findAllByCustomer(customer);
		}else {
			System.err.println("No Order found");
			return new ArrayList<Order>();
		}
	}
}
