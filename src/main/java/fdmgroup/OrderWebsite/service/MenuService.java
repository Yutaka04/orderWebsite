package fdmgroup.OrderWebsite.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.ToppingRepository;

@Service("menuService")
public class MenuService {
	
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private ToppingRepository toppingRepo;

	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private ToppingService toppingService;
	
	private static final Logger log = LogManager.getLogger(MenuService.class);
	
	public List<Drink> getDrinks() {
		return drinkRepo.findAll();
	}
	
	public List<Topping> getToppings(){
		return toppingRepo.findAll();
	}
	
	public void initialiseMenu() {
		if(getToppings().isEmpty()) {
			log.info("ToppingMenuNull: Topping Menu is empty");
			toppingService.initialiseToppingList();
			log.info("ToppingMenuInitialisation: Topping Menu populated.");
		}
		if(getDrinks().isEmpty()) {
			log.info("DrinkMenuNull: Drink Menu is empty");
			drinkService.initialiseDrink();
			log.info("DrinkMenuInitialisation: Drink Menu populated.");
		}
		
	}
	
}
