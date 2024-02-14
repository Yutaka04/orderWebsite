package fdmgroup.OrderWebsite.model.customer;

import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Represents a customer entity with information such as username, password, and associated orders.
 * @author = Danny
 */

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String username; 
	private String password;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerRegistry customerRegistry;
	
	
	/**
     * The list of orders placed by the customer.
     * @OneToMany(mappedBy = "order")
     */
	@OneToMany(mappedBy = "order" )
	private List<Order> orders;
	
	/**
     * Default constructor for JPA compliance.
     */
	public Customer() {
		super();
	}
	
	
	/**
     * Creates a new customer with the specified username and password.
     * @param username The username of the customer.
     * @param password The password associated with the customer's account.
     */
	public Customer(String username, String password) {
		this.username = username; 
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public CustomerRegistry getCustomerRegistry() {
		return customerRegistry;
	}

	public void setCustomerRegistry(CustomerRegistry customerRegistry) {
		this.customerRegistry = customerRegistry;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
