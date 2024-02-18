package fdmgroup.OrderWebsite.service;

import java.util.List;
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

@Service("drinkService")
public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private RecipeService recipeService;
	
	/**
     * Initialise the drinks list if it has not happened.
     */
	public void initialiseDrink() {
		createDrinkAndRecipes("Assam Black Tea", 2.8,3.5,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Jasmine Tea",2.8,3.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Four Season Tea",2.8,3.5, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Milk Tea", 3.6,4.6, "Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Green Milk Tea",3.6,4.6, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Seasons Milk Tea",3.6,4.6, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Hazelnut Milk Tea",4.3,5.5, "Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Hazelnut Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Hazelnut Green Milk Tea",4.3,5.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Hazelnut Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Hazelnut Seasons Milk Tea",4.3,5.5, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Hazelnut Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Toffee Milk Tea",4.3,5.5, "Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Toffee Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Toffee Green Milk Tea",4.3,5.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Toffee Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Toffee Seasons Milk Tea", 4.3,5.5,"Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Toffee Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Vanilla Milk Tea", 4.3,5.5,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Vanilla Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Vanilla Green Milk Tea",4.3,5.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Vanilla Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Vanilla Seasons Milk Tea",4.3,5.5, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Vanilla Syrup", 0.4, 0.5, 0.8, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Milk Tea", 4.3,5.5,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Green Milk Tea",4.3,5.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Seasons Milk Tea", 4.3,5.5,"Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Black Tea",3.8,4.9, "Black Tea", "Sugar", 1.2, 1.7, 2.4, "", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Green Tea",3.8,4.9, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Lychee Seasons Tea",3.8,4.9, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "", "Lychee Syrup", 0.5, 0.7, 1.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Milk Tea",4.3,5.5,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Green Milk Tea", 4.3,5.5,"Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Seasons Milk Tea",4.3,5.5, "Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Black Tea", 3.8,4.9,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Green Tea", 3.8,4.9,"Green Tea", "Sugar", 1.2, 1.7, 2.4, "", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Mango Seasons Tea", 3.8,4.9,"Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "", "Mango Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Milk Tea", 4.3,5.5,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Green Milk Tea", 4.3,5.5,"Green Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Seasons Milk Tea",4.3,5.5,"Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "Creamer", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Black Tea",3.8,4.9,"Black Tea", "Sugar", 1.2, 1.7, 2.4, "", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Green Tea", 3.8,4.9,"Green Tea", "Sugar", 1.2, 1.7, 2.4, "", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Peach Seasons Tea", 3.8,4.9,"Seasons Tea", "Sugar", 1.2, 1.7, 2.4, "", "Peach Syrup", 1.5, 2, 3.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Milk Tea", 4.3,5.5,"Black Tea", "Honey", 0.0, 0.0, 0.0, "Creamer", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Green Milk Tea", 4.3,5.5,"Green Tea", "Honey", 0.0, 0.0, 0.0, "Creamer", "", 0.0, 0.0, 0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Seasons Milk Tea", 4.3,5.5,"Seasons Tea", "Honey", 0.0, 0.0, 0.0, "Creamer", "", 0.0,0.0,0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Black Tea", 3.8,4.9,"Black Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Green Tea", 3.8,4.9,"Green Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Seasons Tea", 3.8,4.9,"Seasons Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Lemon Seasons Milk Tea", 3.8,4.9,"Seasons Tea", "Honey", 0.0, 0.0, 0.0, "Creamer", "", 0.0,0.0,0.0, "", 0.0, 0.0, 0.0);
		createDrinkAndRecipes("Honey Lemon Black Tea",3.8,4.9, "Black Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lemon Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lemon Green Tea",3.8,4.9, "Green Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lemon Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lime Seasons Tea",3.8,4.9,"Seasons Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0,"Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lime Black Tea", 3.8,4.9,"Black Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lime Green Tea", 3.8,4.9,"Green Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lime Seasons Tea", 3.8,4.9,"Seasons Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0,"Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lemon & Lime Black Tea",3.8,4.9,"Black Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lemon & Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Honey Lemon & Lime Green Tea", 3.8,4.9,"Green Tea", "Honey", 0.0, 0.0, 0.0, "", "", 0.0,0.0,0.0, "Lemon & Lime Juice", 1.0, 1.5, 2.0);
		createDrinkAndRecipes("Yakult Green Tea", 4.9,6.5, "Green Tea", "Sugar", 1.2, 1.7, 2.4, "Yakult", "", 0,0,0,"", 0, 0, 0);
		createDrinkAndRecipes("Yakult Red Tea", 4.9,6.5,"Red Tea", "Sugar", 1.2, 1.7, 2.4, "Yakult", "", 0,0,0,"", 0, 0, 0);
		createDrinkAndRecipes("Ribena Yakult Green Tea",4.9,6.5, "Green Tea", "Sugar", 0.4, 0.6, 0.8, "Yakult", "Ribena", 1.5,2.0,3.0,"", 0, 0, 0);
	}
	
	
	
	/**
	 * Creates a new drink with the specified drink name, medium price, and large price.
	 * @param drinkName    The name of the drink.
	 * @param priceMedium  The price of the drink for a medium-sized cup.
	 * @param priceLarge   The price of the drink for a large-sized cup.
	 */
	public void createDrinkAndRecipes(String drinkName, double priceMedium, double priceLarge, 
			String tea, String sweetener, double sweetenerAmt1, double sweetenerAmt2, double sweetenerAmt3,
			String condiment, String syrup, double syrupAmt1, double syrupAmt2, double syrupAmt3,
			String juice,  double juiceAmt1, double juiceAmt2, double juiceAmt3) {
		Drink drink = new Drink();
		drink.setDrinkName(drinkName);
		drink.setPriceMedium(priceMedium);
		drink.setPriceLarge(priceLarge);
		drinkRepo.save(drink);
		recipeService.addRecipesToDrink(drinkName, tea, sweetener, sweetenerAmt1, sweetenerAmt2, sweetenerAmt3,
				condiment, syrup, syrupAmt1, syrupAmt2, syrupAmt3, juice, juiceAmt1, juiceAmt2, juiceAmt3);
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
	
	
	public List<Drink> getAllDrinks(){
		return drinkRepo.findAll();
	}
	
}
