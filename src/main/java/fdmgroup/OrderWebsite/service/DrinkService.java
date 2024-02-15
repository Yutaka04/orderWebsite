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
 * Service class for managing operations related to drinks and recipes.
 * @author = Danny
 */


@Service
public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	 /**
     * Adds a recipe to a drink and saves it to the repository.
     *
     * @param drinkName The name of the drink to which the recipe will be added.
     * @param recipe    The recipe to be added to the drink.
     * @throws IllegalArgumentException If the specified drink is not found.
     */
	public void addRecipeToDrink(String drinkName, Recipe recipe) {
		Optional<Drink> optionalDrink = drinkRepo.findByDrinkName(drinkName);
		if (optionalDrink.isPresent()) {
			Drink drink = optionalDrink.get();
			recipe.setDrink(drink);
			
			recipeRepo.save(recipe);
		}else {
			System.err.println(drinkName + "not found");
			throw new IllegalArgumentException(drinkName + "not found");
		}
		
	}
	
	/**
     * Removes a recipe from a drink and deletes it from the repository.
     *
     * @param drinkName The name of the drink from which the recipe will be removed.
     * @param recipe    The recipe to be removed from the drink.
     * @throws IllegalArgumentException If the specified drink or recipe is not found.
     */
	public void removeRecipeFromDrink(String drinkName, Recipe recipe) {
		Optional<Drink> optionalDrink = drinkRepo.findByDrinkName(drinkName);
		if(optionalDrink.isPresent()) {
			Drink drink = optionalDrink.get();
			List<Recipe> recipes = drink.getRecipes();
			if(recipes.contains(recipe)) {
				recipes.remove(recipe);
				recipeRepo.delete(recipe);
				drinkRepo.save(drink);
			}else {
				System.err.println("Recipe not found for "+ drinkName);
				throw new IllegalArgumentException("Recipe not found for "+ drinkName);
			} 
		}else {
			System.err.println(drinkName + " not found");
			throw new IllegalArgumentException(drinkName + " not found");
		}
		
	}

}
