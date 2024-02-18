package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.CustomerOrder;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.repository.CustomerRepository;
import fdmgroup.OrderWebsite.repository.OrderRecipeRepository;
import fdmgroup.OrderWebsite.repository.OrderRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

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
	
	@Autowired
	private OrderRecipeRepository orderRecipeRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
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
		String sweetener = recipeRepo.findAllByDrinkName(drinkName).get(0).getSweetener();
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
	public boolean addOrderToCustomer(String username, CustomerOrder order) {
		Optional<Customer> customerOptional = customerRepo.findByUsername(username);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			order.setCustomer(customer);
			orderRepo.save(order);
			return true;
		}else {
			System.err.println(username + " does not exist");
			return false;
		}
	}
	
	
	/**
     * Retrieves a list of all OrderRecipes stored in the repository.
     * @return A list of OrderRecipes.
     */
	public void updateOrderStatus(CustomerOrder orderToFind, String status) {
		Optional<CustomerOrder> orderOptional = orderRepo.findById(orderToFind.getOrderId());
		if(orderOptional.isPresent()) {
			CustomerOrder order = orderOptional.get();
			order.setOrderStatus(status);
			orderRepo.save(order);
			
			System.out.println("CustomerOrder Status updated!");
			
			Optional<OrderRecipe> orderRecipeOptional = orderRecipeRepo.findByOrder_OrderId(order.getOrderId());
			if(orderRecipeOptional.isPresent()) {
				OrderRecipe orderRecipe = orderRecipeOptional.get();
				orderRecipe.setOrderStatus(status);
				orderRecipeRepo.save(orderRecipe);
				
				System.out.println("CustomerOrder Status updated!");
			}else {
				System.err.println("CustomerOrder Recipe for "+ orderToFind.getOrderId() + " does not exist");
			}
		}else {
			System.err.println("CustomerOrder for "+ orderToFind.getOrderId() + " does not exist");
		}
	}
	
}
