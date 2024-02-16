package fdmgroup.OrderWebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.MenuRepository;
import fdmgroup.OrderWebsite.repository.ToppingRepository;

/**
 * Service class for managing the menu, including adding, deleting, and retrieving drinks.
 * @author = Danny
 */

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private ToppingRepository toppingRepo;
	
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
     * Retrieves all drinks in the menu.
     * @return A list of all drinks in the menu.
     */
	public List<Drink> getAllDrink() {
		return menuRepo.findAll();
	}
	

	
	//Get Drink Price
	
	//Get Topping Price
	
	//Get Total Price for the drink
}
