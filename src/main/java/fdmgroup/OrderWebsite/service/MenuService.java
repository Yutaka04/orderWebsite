package fdmgroup.OrderWebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.MenuRepository;

/**
 * Service class for managing the menu, including adding, deleting, and retrieving drinks.
 *
 * @author = Danny
 * @version 1.0
 */

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepo;
	
	/**
     * Adds a new drink to the menu along with its prices and recipes at different sizes.
     * @param drink The drink to be added to the menu.
     * @return True if the drink is successfully added, false if the drink already exists in the menu.
     */
	public boolean addNewDrink(Drink drink) {
		Optional<Drink> drinkOptional = menuRepo.findByDrinkName(drink.getDrinkName());
		if (drinkOptional.isEmpty()) {
			menuRepo.save(drink);
			return true;
		} else {
			return false;
		}
	}
	
	/**
     * Removes an existing drink from the menu.
     * @param drink The drink to be removed from the menu.
     */
	public void deleteDrink(Drink drink) {
		Optional<Drink> drinkOptional = menuRepo.findByDrinkName(drink.getDrinkName());
		if (!drinkOptional.isEmpty()) {
			menuRepo.delete(drink);
			System.out.println(drink.getDrinkName() + " is removed.");
		} else {
			System.err.println(drink.getDrinkName() + " is not found in Menu");
		}
	}
	
	/**
     * Retrieves all drinks in the menu.
     * @return A list of all drinks in the menu.
     */
	public List<Drink> getAllDrink() {
		return menuRepo.findAll();
	}
	
	/**
     * Obtains the price of the drink based on the specified cup size.
     * @param drink    The drink for which the price is to be obtained.
     * @param cupSize  The cup size for which the price is requested.
     * @return The price of the drink for the specified cup size, or -1 if the drink or cup size is not found.
     */
	public double getPricebyCupSize(Drink drink,String cupSize) {
		if(menuRepo.findByDrinkName(drink.getDrinkName()).get().getCupSize().equals(cupSize)) {
			return menuRepo.findByDrinkName(drink.getDrinkName()).get().getPrice();
		}
		System.err.println(drink.getDrinkName() + " does not exist");
		return -1;
	}
	
}
