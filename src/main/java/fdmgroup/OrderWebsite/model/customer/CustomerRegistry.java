package fdmgroup.OrderWebsite.model.customer;

import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerRegistry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerRegistry;
	
	@OneToMany(mappedBy = "customer" )
	private List<Customer> customers;
	
	public CustomerRegistry() {
		super();
	}

	public int getCustomerRegistry() {
		return customerRegistry;
	}

	public void setCustomerRegistry(int customerRegistry) {
		this.customerRegistry = customerRegistry;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
