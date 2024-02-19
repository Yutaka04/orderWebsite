package fdmgroup.OrderWebsite.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.repository.DrinkRepository;

/**
 * Service class for managing operations related to drinks and recipes.
 * @author = Danny
 */

@Service("drinkService")
public class DrinkService {
	@Autowired
	private DrinkRepository drinkRepo;
	
	private static final Logger log = LogManager.getLogger(DrinkService.class);
	
	/**
     * Initialise the drinks list if it has not happened.
     */
	public void initialiseDrink() {
		createDrink("Assam Black Tea", 2.8,3.5);
		createDrink("Jasmine Tea",2.8,3.5);
		createDrink("Four Season Tea",2.8,3.5);
		createDrink("Milk Tea", 3.6,4.6);
		createDrink("Green Milk Tea",3.6,4.6);
		createDrink("Seasons Milk Tea",3.6,4.6);
		createDrink("Hazelnut Milk Tea",4.3,5.5);
		createDrink("Hazelnut Green Milk Tea",4.3,5.5);
		createDrink("Hazelnut Seasons Milk Tea",4.3,5.5);
		createDrink("Toffee Milk Tea",4.3,5.5);
		createDrink("Toffee Green Milk Tea",4.3,5.5);
		createDrink("Toffee Seasons Milk Tea", 4.3,5.5);
		createDrink("Vanilla Milk Tea", 4.3,5.5);
		createDrink("Vanilla Green Milk Tea",4.3,5.5);
		createDrink("Vanilla Seasons Milk Tea",4.3,5.5);
		createDrink("Lychee Milk Tea", 4.3,5.5);
		createDrink("Lychee Green Milk Tea",4.3,5.5);
		createDrink("Lychee Seasons Milk Tea", 4.3,5.5);
		createDrink("Lychee Black Tea",3.8,4.9);
		createDrink("Lychee Green Tea",3.8,4.9);
		createDrink("Lychee Seasons Tea",3.8,4.9);
		createDrink("Mango Milk Tea",4.3,5.5);
		createDrink("Mango Green Milk Tea", 4.3,5.5);
		createDrink("Mango Seasons Milk Tea",4.3,5.5);
		createDrink("Mango Black Tea", 3.8,4.9);
		createDrink("Mango Green Tea", 3.8,4.9);
		createDrink("Mango Seasons Tea", 3.8,4.9);
		createDrink("Peach Milk Tea", 4.3,5.5);
		createDrink("Peach Green Milk Tea", 4.3,5.5);
		createDrink("Peach Seasons Milk Tea",4.3,5.5);
		createDrink("Peach Black Tea",3.8,4.9);
		createDrink("Peach Green Tea", 3.8,4.9);
		createDrink("Peach Seasons Tea", 3.8,4.9);
		createDrink("Honey Milk Tea", 4.3,5.5);
		createDrink("Honey Green Milk Tea", 4.3,5.5);
		createDrink("Honey Seasons Milk Tea", 4.3,5.5);
		createDrink("Honey Black Tea", 3.8,4.9);
		createDrink("Honey Green Tea", 3.8,4.9);
		createDrink("Honey Seasons Tea", 3.8,4.9);
		createDrink("Honey Lemon Seasons Milk Tea", 3.8,4.9);
		createDrink("Honey Lemon Black Tea",3.8,4.9);
		createDrink("Honey Lemon Green Tea",3.8,4.9);
		createDrink("Honey Lime Seasons Tea",3.8,4.9);
		createDrink("Honey Lime Black Tea", 3.8,4.9);
		createDrink("Honey Lime Green Tea", 3.8,4.9);
		createDrink("Honey Lime Seasons Tea", 3.8,4.9);
		createDrink("Honey Lemon & Lime Black Tea",3.8,4.9);
		createDrink("Honey Lemon & Lime Green Tea", 3.8,4.9);
		createDrink("Yakult Green Tea", 4.9,6.5);
		createDrink("Yakult Red Tea", 4.9,6.5);
		createDrink("Ribena Yakult Green Tea",4.9,6.5);
	}
	
	
	
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
		log.info("DrinkSuccess: Drink with Name:{}, Medium Price:{}, Large Price:{} added.".formatted(drinkName, priceMedium,priceLarge));
	}
	
	/**
     * Removes an existing drink from the menu.
     * @param drink The drink to be removed from the menu.
     */
	public void deleteDrink(Drink drink) {
		Optional<Drink> drinkOptional = drinkRepo.findByDrinkName(drink.getDrinkName());
		if (!drinkOptional.isEmpty()) {
			log.info("DrinkSuccess: Drink with Name:{} removed.".formatted(drink.getDrinkName()));
			drinkRepo.delete(drink);
		} else {
			log.error("DrinkError: Drink with Name:{} is not found in Drink Menu.".formatted(drink.getDrinkName()));
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
				log.info("DrinkSuccess: {} found in Drink Menu; {} returned.".formatted(drinkName,drinkRepo.findByDrinkName(drinkName).get().getPriceMedium()));
				return drinkRepo.findByDrinkName(drinkName).get().getPriceMedium();
			}else {
				log.info("DrinkSuccess: {} found in Drink Menu; {} returned.".formatted(drinkName,drinkRepo.findByDrinkName(drinkName).get().getPriceLarge()));
				return drinkRepo.findByDrinkName(drinkName).get().getPriceLarge();
			}
		}else {
			log.info("DrinkError: {} not found in Drink Menu; {} returned.".formatted(drinkName));
			return 0;
		}
	}
	
	public List<Drink> getAllDrinks(){
		log.info("DrinkSuccess: Drink Menu retrieved.");
		return drinkRepo.findAll();
	}
	
}
