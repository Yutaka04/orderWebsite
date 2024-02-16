package fdmgroup.OrderWebsite.model.store;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

public class DrinkTest {

	@Test
	void createDrink_ReturnDrink_whenCalled() {
		Drink drink = new Drink();
		Random random = new Random();
		String drinkNameTest = random.toString();
		double priceMTest = random.nextDouble();
		double priceLTest = random.nextDouble();
		
		drink.createDrink(drinkNameTest, priceMTest, priceLTest);
		
		assertEquals(drink.getDrinkName(),drinkNameTest);
		assertEquals(drink.getPriceMedium(),priceMTest,0);
		assertEquals(drink.getPriceLarge(),priceLTest,0);
	}
	
	
	@Test
	void getPriceByCupSize_ReturnPriceMedium_whenCalled() {
		Drink drink = new Drink();
		Random random = new Random();
		String drinkNameTest = random.toString();
		double priceMTest = random.nextDouble();
		double priceLTest = random.nextDouble();
		
		drink.createDrink(drinkNameTest, priceMTest, priceLTest);
		
		assertEquals(drink.getPriceByCupSize("M"),priceMTest,0);
		
	}
	
	@Test
	void getPriceByCupSize_ReturnPriceLarge_whenCalled() {
		Drink drink = new Drink();
		Random random = new Random();
		String drinkNameTest = random.toString();
		double priceMTest = random.nextDouble();
		double priceLTest = random.nextDouble();
		
		drink.createDrink(drinkNameTest, priceMTest, priceLTest);
		
		assertEquals(drink.getPriceByCupSize("L"),priceLTest,0);
		
	}
	
	@Test
	void getRecipe_ReturnCorrectRecipe_whenRecipeSizeCalled() {
		Drink drink = new Drink();
		Recipe recipe1 = new Recipe();
		recipe1.setRecipeSize("S");
		Recipe recipe2 = new Recipe();
		recipe2.setRecipeSize("M");
		Recipe recipe3 = new Recipe();
		recipe3.setRecipeSize("L");
		drink.getRecipes().add(recipe1);
		drink.getRecipes().add(recipe2);
		drink.getRecipes().add(recipe3);
		
		assertEquals(drink.getRecipeByRecipeSize("S"),recipe1);
		assertEquals(drink.getRecipeByRecipeSize("M"),recipe2);
		assertEquals(drink.getRecipeByRecipeSize("L"),recipe3);
	}
	
}
