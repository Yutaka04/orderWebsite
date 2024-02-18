package fdmgroup.OrderWebsite.model.customer;

import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Represents a customer entity with information such as username, password, and associated orders.
 * @author = Danny
 */

@Entity
@Table(name = "`Customer`")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId")
	private int customerId;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "customer")
	private List<CustomerOrder> orders;
	
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

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	
	
}
