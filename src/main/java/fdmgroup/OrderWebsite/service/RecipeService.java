package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
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
	
	public void deleteRecipeByDrinkName(String drinkName) {
		while()
	}
}
