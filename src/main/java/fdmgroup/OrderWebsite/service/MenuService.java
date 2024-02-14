package fdmgroup.OrderWebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private ToppingService toppingService;
	
	//Add new drinks & its prices & its recipes at different sizes
	public boolean addNewDrink(Drink drink) {
		Optional<Drink> drinkOptional = menuRepo.findByDrinkName(drink.getDrinkName());
		if (drinkOptional.isEmpty()) {
			menuRepo.save(drink);
			return true;
		} else {
			return false;
		}
	}
	
	//Remove existing drinks from the menu
	public void deleteDrink(Drink drink) {
		Optional<Drink> drinkOptional = menuRepo.findByDrinkName(drink.getDrinkName());
		if (!drinkOptional.isEmpty()) {
			menuRepo.delete(drink);
			System.out.println(drink.getDrinkName() + " is removed.");
		} else {
			System.err.println(drink.getDrinkName() + " is not found in Menu");
		}
	}
	
	//Find all drinks in the menu
	public List<Drink> getAllDrink() {
		return menuRepo.findAll();
	}
	
	//Obtain the price of the drink based on the cupSize
	public double getPricebyCupSize(Drink drink,String cupSize) {
		if(menuRepo.findByDrinkName(drink.getDrinkName()).get().getCupSize().equals(cupSize)) {
			return menuRepo.findByDrinkName(drink.getDrinkName()).get().getPrice();
		}
		System.err.println(drink.getDrinkName() + " does not exist");
		return -1;
	}
	
	public double getPricebyCupSize(Topping topping,String cupSize) {
		if(menuRepo.findByToppingName(toppingService.getToppingByToppingName(topping.getToppingName()).get().getCupSize().equals(cupSize)) {
			return menuRepo.findByDrinkName(drink.getDrinkName()).get().getPrice();
		}
		System.err.println("Not found");
		return -1;
	}
}
