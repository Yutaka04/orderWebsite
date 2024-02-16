package fdmgroup.OrderWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;

/**
 * Service class for managing operations related to drinks and recipes.
 * @author = Danny
 */

@Service
public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	/**
	 * Creates a new drink with the specified drink name, medium price, and large price.
	 * @param drinkName    The name of the drink.
	 * @param priceMedium  The price of the drink for a medium-sized cup.
	 * @param priceLarge   The price of the drink for a large-sized cup.
	 */
	public void createDrink(String drinkName, double priceMedium, double priceLarge) {
		Drink drink = new Drink();
		drink.setDrinkName(drinkName);
		drink.setPriceMedium(priceMedium);
		drink.setPriceLarge(priceLarge);
		drinkRepo.save(drink);
	}
	
	/**
     * Removes an existing drink from the menu.
     * @param drink The drink to be removed from the menu.
     */
	public void deleteDrink(Drink drink) {
		Optional<Drink> drinkOptional = drinkRepo.findByDrinkName(drink.getDrinkName());
		if (!drinkOptional.isEmpty()) {
			drinkRepo.delete(drink);
			System.out.println(drink.getDrinkName() + " is removed.");
		} else {
			System.err.println(drink.getDrinkName() + " is not found in Menu");
		}
	}
	
	/**
	 * Retrieves the recipe for the specified recipe size.
	 * @param drinkName The name of the drink.
	 * @param recipeSize The size of the recipe to retrieve.
	 * @return The Recipe object corresponding to the specified recipe size,
	 *         or an empty Recipe object if no match is found.
	 */
	public Recipe getRecipeByDrinkNameAndRecipeSize(String drinkName,String recipeSize) {
		Optional<Drink> drinkOptional = drinkRepo.findByDrinkName(drinkName);
		if (!drinkOptional.isEmpty()) {
			Drink drink = drinkOptional.get();
			for(Recipe r:drink.getRecipes()) {
				if(r.getRecipeSize().equals(recipeSize)) {
					return r;
				}
			}
				System.err.println(recipeSize + " not found");
				return null;
		} else {
			System.err.println(drinkName + " is not found in Menu");
			return null;
		}
	}
	
	/**
	 * Retrieves the drink price based on the cup size.
	 * @param drinkName The name of the drink.
	 * @param cupSize The size of the cup ("M" for medium, "L" for large).
	 * @return The price of the drink for the specified cup size.
	 */
	public double getPriceByDrinkNameAndCupSize(String drinkName, String cupSize) {
		if(drinkRepo.findByDrinkName(drinkName).isEmpty()) {
			if(cupSize.equals("M")) {
				return drinkRepo.findByDrinkName(drinkName).get().getPriceMedium();
			}else {
				return drinkRepo.findByDrinkName(drinkName).get().getPriceLarge();
			}
		}else {
			System.err.println(drinkName + " not found!");
			return 0;
		}
	}
	
	
}
