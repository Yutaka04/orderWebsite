package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.Order;
import fdmgroup.OrderWebsite.repository.CustomerRepository;
import fdmgroup.OrderWebsite.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public void createOrder(String drinkName, String cupSize,String sweetener, String sweetenerLevel, 
			String iceLevel, String toppingName, boolean lessTopping) {
		Order order = new Order();
		order.setDrinkName(drinkName);
		order.setOrderTime();
		order.setOrderStatus("Incomplete");
		order.setCupSize(cupSize);
		order.setSweetener(sweetener);
		order.setSweetenerLevel(sweetenerLevel);
		order.setSweetenerModifier(sweetener, sweetenerLevel);
		order.setIceLevel(iceLevel);
		order.setIceLevelModifier(iceLevel);
		order.setToppingName(toppingName);
		order.setToppingStatus();
		order.setLessTopping(lessTopping);
		order.setToppingMass(cupSize,order.isToppingStatus(),order.isLessTopping());
		orderRepo.save(order);
	}
	
	
	public void addOrderToCustomer(String username, Order order) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			order.setCustomer(customer);
			orderRepo.save(order);
		}else {
			System.err.println(username + " does not exist");
		}
	}
	
	//Move to CustomerService
	public void cancelOrderByDrinkName(String username, Order order) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			order.setCustomer(customer);
			orderRepo.save(order);
		}else {
			System.err.println(username + " does not exist");
		}
	}
}
