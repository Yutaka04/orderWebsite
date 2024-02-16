package fdmgroup.OrderWebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.customer.Order;
import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.OrderRecipeRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

@Service
public class OrderRecipeService {
	
	@Autowired
	private OrderRecipeRepository orderRecipeRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	public void createOrderRecipe(Order order, Drink drink) {
		OrderRecipe orderRecipe = new OrderRecipe();
		if(order.getDrinkName().equals(drink.getDrinkName())) {
			orderRecipe.setCustomerId(order.getCustomer().getCustomerId());
			orderRecipe.setDrinkName(order.getDrinkName());
			orderRecipe.setCupSize(order.getCupSize());
			orderRecipe.setToppingName(order.getToppingName());
			orderRecipe.setToppingStatus(order.isToppingStatus());
			orderRecipe.setToppingModifier(order.getToppingModifier());
			orderRecipe.setToppingMass(order.getToppingMass());
			orderRecipe.setIceLevelModifier(order.getIceLevelModifier());
			orderRecipe.setSweetenerModifier(order.getSweetenerModifier());
			orderRecipe.setRecipeSize();
			Recipe recipe = findByDrinkNameAndRecipeSize(orderRecipe.getDrinkName(), orderRecipe.getRecipeSize());
			orderRecipe.setTea(recipe.getTea());
			orderRecipe.setTeaVolume(recipe.getTeaVolume()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingModifier()));
			orderRecipe.setSweetener(order.getSweetener());
			orderRecipe.setSweetenerAmount(recipe.getSweetenerAmount()*orderRecipe.getSweetenerModifier()*(1+orderRecipe.getSweetenerModifier()));
			orderRecipe.setCondiment(recipe.getCondiment());
			orderRecipe.setCondimentAmount(orderRecipe.getCondiment(),recipe.getCondimentAmount(),orderRecipe.getIceLevelModifier(),orderRecipe.getToppingModifier());
			orderRecipe.setSyrup(recipe.getSyrup());
			orderRecipe.setSyrupAmount(recipe.getSyrupAmount()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingMass()));
			orderRecipe.setJuice(recipe.getJuice());
			orderRecipe.setJuiceAmount(recipe.getJuiceAmount()*(1+orderRecipe.getIceLevelModifier()+orderRecipe.getToppingMass()));
			orderRecipe.setOrderTime(order.getOrderTime());
			orderRecipe.setOrderStatus(order.getOrderStatus());
			orderRecipeRepo.save(orderRecipe);
			}else {
				System.err.println(order.getDrinkName() + " " + drink.getDrinkName() + " do not match" );
			}
		}

	public Recipe findByDrinkNameAndRecipeSize(String drinkName, String recipeSize) {
		List<Recipe> recipes = recipeRepo.findbyDrinkName(drinkName);
		for (Recipe r:recipes) {
			if(r.getRecipeSize().equals(recipeSize)) {
				return r;
			}
		}
		System.err.println("Recipe for " + drinkName + " not found");
		return null;
	}
	
	public List<OrderRecipe> getAllOrderRecipes(){
		return orderRecipeRepo.findAll();
	}
	
}
