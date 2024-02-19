package fdmgroup.OrderWebsite.service;

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
 * Service class responsible for managing order recipes, including creation and retrieval.
 * This class interacts with the OrderRecipeRepository and RecipeRepository.
 * @author Your Name
 */

@Service("orderService")
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	private static final Logger log = LogManager.getLogger(OrderService.class);
	
	/**
     * Creates an OrderRecipe based on the provided CustomerOrder and Drink.
     * Retrieves the necessary details from the CustomerOrder and sets them in the OrderRecipe.
     * If the drink names in the CustomerOrder and Drink do not match, an error message is printed.
     * @param order The CustomerOrder containing customer and drink details.
     * @param drink The Drink to be associated with the OrderRecipe.
     */
	public void createOrder(String drinkName, String cupSize, String sweetenerLevel, 
			String iceLevel, String toppingName, boolean lessTopping) {
		CustomerOrder order = new CustomerOrder();
		order.setDrinkName(drinkName);
		order.setOrderTime();
		order.setOrderStatus("Incomplete");
		order.setCupSize(cupSize);
		order.setSweetenerLevel(sweetenerLevel);
		order.setIceLevel(iceLevel);
		order.setToppingName(toppingName);
		order.setToppingStatus();
		order.setLessTopping(lessTopping);
		orderRepo.save(order);
		log.info("OrderSuccess: Order with id {}, Drink: {}, Size: {}, Sweetener Level: {}, Ice Level: {}, "
				+ "Topping: {},Topping Staus: {}, Less Topping?: {} created!".formatted(order.getOrderId(),
						drinkName,cupSize,sweetenerLevel,iceLevel,toppingName,toppingName.equals("N.A"),lessTopping));
	}
	
	
	 /**
     * Finds a Recipe based on the given drink name and recipe size.
     * @param drinkName   The name of the drink.
     * @param recipeSize  The size of the recipe.
     * @return            The Recipe matching the criteria, or null if not found.
     */
	public boolean addOrderToCustomer(String username, CustomerOrder order) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			order.setCustomer(customer);
			orderRepo.save(order);
			log.info("OrderSuccess: Order with id" + order.getOrderId() + "added to customer with username " + customer.getUsername());
			return true;
		}else {
			log.error("OrderError: Customer with username " + username + " does not exist.");
			return false;
		}
	}
	
}
