package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.hibernate.SessionFactory;
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

@Deprecated
@Service("recipeService")
public class RecipeService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	@Autowired
	private SessionFactory session;
	
	
	/**
     * Creates a new recipe with the specified details.
     * @param drink --> The drink the recipe belongs to.
     * @param drinkName --> The name of the drink.
     * @param tea  --> The type of liquid (tea) used in the recipe.
     * @param syrup --> The syrup used in the recipe.
     * @param syrupAmt --> The amount of syrup used.
     * @param condiment --> The condiment used in the recipe.
     * @param syrup --> The syrup used in the recipe.
     * @param syrupAmt --> The amount of syrup used.
     * @param juice --> The juice used in the recipe.
     * @param juiceAmt --> The amount of juice used.
	 * @return 
     */
	public void createRecipe(Drink drink, String recipeSize, String tea, String sweetener, double sweetenerAmt, 
			String condiment,String syrup,double syrupAmt, String juice, double juiceAmt) {
        Recipe recipe = new Recipe();
    	recipe.setDrinkName(drink.getDrinkName());
    	recipe.setRecipeSize(recipeSize);
    	recipe.setTea(tea);
    	recipe.setTeaVolume(recipeSize);
    	recipe.setSweetener(sweetener);
    	recipe.setSweetenerAmount(sweetener, recipeSize, sweetenerAmt);
    	recipe.setCondiment(condiment, recipeSize);
        recipe.setSyrup(syrup,syrupAmt);
        recipe.setJuice(juice,juiceAmt);
        recipe.setDrink(drink);
        recipeRepo.save(recipe);	
    }
	
	/**
     * Creates a new recipe based on the provided information and associates it with an existing drink.
     * @param drinkName      The name of the drink to associate the recipe with.
     * @param tea            The type of liquid (tea) used in the recipe.
     * @param syrup      The syrup used in the recipe.
     * @param syrupAmt1   The amount of syrup used for recipe size S.
     * @param syrupAmt2   The amount of syrup used for recipe size M.
     * @param syrupAmt3   The amount of syrup used for recipe size L.
     * @param condiment      The condiment used in the recipe.
     * @param syrup          The syrup used in the recipe.
     * @param syrupAmt1   The amount of syrup used for recipe size S.
     * @param syrupAmt2   The amount of syrup used for recipe size M.
     * @param syrupAmt3   The amount of syrup used for recipe size L.
     * @param juice          The juice used in the recipe.
     * @param juiceAmt1   The amount of juice used for recipe size S.
     * @param juiceAmt2   The amount of juice used for recipe size M.
     * @param juiceAmt3   The amount of juice used for recipe size L.
     * @throws IllegalArgumentException if the specified drink is not found.
     */
	public void addRecipesToDrink(String drinkName, String tea, String sweetener, 
			double sweetenerAmt1, double sweetenerAmt2, double sweetenerAmt3,
			String condiment, String syrup, double syrupAmt1, double syrupAmt2, double syrupAmt3,
			String juice,  double juiceAmt1, double juiceAmt2, double juiceAmt3) {
		Optional<Drink> optionalDrink = drinkRepo.findByDrinkName(drinkName);
		if(optionalDrink.isPresent()) {
			Drink drink = optionalDrink.get();
			drink = session.getCurrentSession().merge(drink);
			createRecipe(drink,"S",tea,sweetener,sweetenerAmt1,condiment,syrup,syrupAmt1,juice,juiceAmt1);
			createRecipe(drink,"M",tea,sweetener,sweetenerAmt2,condiment,syrup,syrupAmt2,juice,juiceAmt2);
			createRecipe(drink,"L",tea,sweetener,sweetenerAmt3,condiment,syrup,syrupAmt3,juice,juiceAmt3);
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
		recipeRepo.deleteRecipesByDrinkName(drinkName);
	}
}
