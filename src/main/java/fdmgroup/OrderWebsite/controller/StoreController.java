package fdmgroup.OrderWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fdmgroup.OrderWebsite.service.DrinkService;
import fdmgroup.OrderWebsite.service.OrderRecipeService;
import fdmgroup.OrderWebsite.service.OrderService;
import fdmgroup.OrderWebsite.service.RecipeService;
import fdmgroup.OrderWebsite.service.ToppingService;

@Controller
public class StoreController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private OrderRecipeService orderRecipeService;
	
	@Autowired
	private ToppingService toppingService;
}
