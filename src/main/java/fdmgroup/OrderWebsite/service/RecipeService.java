package fdmgroup.OrderWebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

/**
 * Service class for managing recipes and their association with drinks.
 * @author =  Danny
 */

@Service
public class RecipeService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	 /**
     * Creates a new recipe based on the provided information and associates it with an existing drink.
     * @param drinkName      The name of the drink to associate the recipe with.
     * @param tea            The type of liquid (tea) used in the recipe.
     * @param sweetener      The sweetener used in the recipe.
     * @param sweetenerAmt   The amount of sweetener used.
     * @param condiment      The condiment used in the recipe.
     * @param syrup          The syrup used in the recipe.
     * @param syrupAmt       The amount of syrup used.
     * @param juice          The juice used in the recipe.
     * @param juiceAmt       The amount of juice used.
     * @throws IllegalArgumentException if the specified drink is not found.
     */
	public void createRecipe(String drinkName, String tea, String sweetener, double sweetenerAmt, 
			String condiment,String syrup,double syrupAmt, String juice, double juiceAmt) {
		Optional<Drink> optionalDrink = drinkRepo.findbyDrinkName(drinkName);
		if(optionalDrink.isPresent()) {
			Drink drink = optionalDrink.get();
			Recipe recipe = new Recipe();
			recipe.createRecipe(drinkName, tea, sweetener, sweetenerAmt, condiment, syrup, syrupAmt, juice, juiceAmt);
			recipe.setDrink(drink);
			recipeRepo.save(recipe);
		}else {
			System.err.println(drinkName + " not found");
			throw new IllegalArgumentException(drinkName + " not found");
		}
	}
	
	/**
     * Deletes all recipes associated with a specified drink by its name.
     * @param drinkName The name of the drink for which recipes should be deleted.
     */
	public void deleteRecipeByDrinkName(String drinkName) {
		List<Recipe> recipes;
		recipes = recipeRepo.findbyDrinkName(drinkName);
		recipeRepo.deleteAll(recipes);
	}
}
