package fdmgroup.OrderWebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Menu;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.MenuRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;
import fdmgroup.OrderWebsite.repository.ToppingRepository;

@Service("menuService")
public class MenuService {

	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private ToppingRepository toppingRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private ToppingService toppingService;
	
	
	public List<Drink> getDrinks() {
		return drinkRepo.findAll();
	}
	
	public List<Topping> getToppings(){
		return toppingRepo.findAll();
	}
	
	public List<Recipe> getRecipes(){
		return recipeRepo.findAll();
	}
	
	public void initialiseMenu() {
		if(getToppings().isEmpty()) {
			toppingService.initialiseToppingList();
		}
		if(getDrinks().isEmpty()) {
			drinkService.initialiseDrink();
		}
		
	}
	
}
