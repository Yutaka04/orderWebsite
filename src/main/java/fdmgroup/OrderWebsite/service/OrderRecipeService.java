package fdmgroup.OrderWebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Order;
import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.OrderRecipeRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

/**
 * Service class responsible for managing order recipes, including creation and retrieval.
 * This class interacts with the OrderRecipeRepository and RecipeRepository.
 * @author = Danny
 */

@Service
public class OrderRecipeService {
	
	@Autowired
	private OrderRecipeRepository orderRecipeRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	
	/**
     * Creates an OrderRecipe based on the provided Order and Drink.
     * Retrieves the necessary details from the Order and sets them in the OrderRecipe.
     * If the drink names in the Order and Drink do not match, an error message is printed.
     * @param order The Order containing customer and drink details.
     * @param drink The Drink to be associated with the OrderRecipe.
     */
	public void createOrderRecipe(Order order, Drink drink) {
		OrderRecipe orderRecipe = new OrderRecipe();
		if(order.getDrinkName().equals(drink.getDrinkName())) {
			orderRecipe.setCustomerId(order.getCustomer().getCustomerId());
			orderRecipe.setDrinkName(order.getDrinkName());
			orderRecipe.setOrderId(order.getOrderId());
			orderRecipe.setCupSize(order.getCupSize());
			orderRecipe.setToppingName(order.getToppingName());
			orderRecipe.setToppingStatus(order.isToppingStatus());
			orderRecipe.setToppingModifier(order.getToppingModifier());
			orderRecipe.setToppingMass(order.getToppingMass());
			orderRecipe.setIceLevelModifier(order.getIceLevelModifier());
			orderRecipe.setSweetenerModifier(order.getSweetenerModifier());
			orderRecipe.setRecipeSize();
			Recipe recipe = findByDrinkNameAndRecipeSize(orderRecipe.getDrinkName(), orderRecipe.getRecipeSize());
			orderRecipe.setTea(recipe.getTea());
			orderRecipe.setTeaVolume(recipe.getTeaVolume()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingModifier()));
			orderRecipe.setSweetener(order.getSweetener());
			orderRecipe.setSweetenerAmount(recipe.getSweetenerAmount()*orderRecipe.getSweetenerModifier()*(1+orderRecipe.getSweetenerModifier()));
			orderRecipe.setCondiment(recipe.getCondiment());
			orderRecipe.setCondimentAmount(orderRecipe.getCondiment(),recipe.getCondimentAmount(),orderRecipe.getIceLevelModifier(),orderRecipe.getToppingModifier());
			orderRecipe.setSyrup(recipe.getSyrup());
			orderRecipe.setSyrupAmount(recipe.getSyrupAmount()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingMass()));
			orderRecipe.setJuice(recipe.getJuice());
			orderRecipe.setJuiceAmount(recipe.getJuiceAmount()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingMass()));
			orderRecipe.setOrderTime(order.getOrderTime());
			orderRecipe.setOrderStatus(order.getOrderStatus());
			orderRecipeRepo.save(orderRecipe);
			}else {
				System.err.println(order.getDrinkName() + " " + drink.getDrinkName() + " do not match" );
			}
		}

	/**
     * Finds a Recipe based on the given drink name and recipe size.
     * @param drinkName   The name of the drink.
     * @param recipeSize  The size of the recipe.
     * @return            The Recipe matching the criteria, or null if not found.
     */
	public Recipe findByDrinkNameAndRecipeSize(String drinkName, String recipeSize) {
		List<Recipe> recipes = recipeRepo.findbyDrinkName(drinkName);
		for (Recipe r:recipes) {
			if(r.getRecipeSize().equals(recipeSize)) {
				return r;
			}
		}
		System.err.println("Recipe for " + drinkName + " not found");
		return null;
	}
	
	/**
     * Retrieves a list of all OrderRecipes stored in the repository.
     * @return A list of OrderRecipes.
     */
	public List<OrderRecipe> getAllOrderRecipes(){
		return orderRecipeRepo.findAll();
	}
	
}