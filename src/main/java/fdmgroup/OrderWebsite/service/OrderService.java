package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.Order;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.repository.CustomerRepository;
import fdmgroup.OrderWebsite.repository.OrderRecipeRepository;
import fdmgroup.OrderWebsite.repository.OrderRepository;

/**
 * Service class responsible for managing order recipes, including creation and retrieval.
 * This class interacts with the OrderRecipeRepository and RecipeRepository.
 * @author Your Name
 */

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrderRecipeRepository orderRecipeRepo;
	
	
	/**
     * Creates an OrderRecipe based on the provided Order and Drink.
     * Retrieves the necessary details from the Order and sets them in the OrderRecipe.
     * If the drink names in the Order and Drink do not match, an error message is printed.
     * @param order The Order containing customer and drink details.
     * @param drink The Drink to be associated with the OrderRecipe.
     */
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
	
	
	 /**
     * Finds a Recipe based on the given drink name and recipe size.
     * @param drinkName   The name of the drink.
     * @param recipeSize  The size of the recipe.
     * @return            The Recipe matching the criteria, or null if not found.
     */
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
	
	
	/**
     * Retrieves a list of all OrderRecipes stored in the repository.
     * @return A list of OrderRecipes.
     */
	public void updateOrderStatus(Order orderToFind, String status) {
		Optional<Order> orderOptional = orderRepo.findById(orderToFind.getOrderId());
		if(orderOptional.isPresent()) {
			Order order = orderOptional.get();
			order.setOrderStatus(status);
			orderRepo.save(order);
			
			System.out.println("Order Status updated!");
			
			Optional<OrderRecipe> orderRecipeOptional = orderRecipeRepo.findByOrderId(order.getOrderId());
			if(orderRecipeOptional.isPresent()) {
				OrderRecipe orderRecipe = orderRecipeOptional.get();
				orderRecipe.setOrderStatus(status);
				orderRecipeRepo.save(orderRecipe);
				
				System.out.println("Order Status updated!");
			}else {
				System.err.println("Order Recipe for "+ orderToFind.getOrderId() + " does not exist");
			}
		}else {
			System.err.println("Order for "+ orderToFind.getOrderId() + " does not exist");
		}
	}
}
