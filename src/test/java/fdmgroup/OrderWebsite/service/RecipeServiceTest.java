package fdmgroup.OrderWebsite.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fdmgroup.OrderWebsite.model.customer.CupSize;
import fdmgroup.OrderWebsite.model.customer.ToppingCustomiser;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;


@SpringBootTest(classes = {RecipeService.class})
public class RecipeServiceTest {
	
	@MockBean
    private DrinkRepository drinkRepo;

    @MockBean
    private RecipeRepository recipeRepo;

    @InjectMocks
    private RecipeService recipeService;
	
	
	@Test
	public void testCreateRecipe() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		CupSize cupSize = recipe.getCupSizeSelector();
		ToppingCustomiser toppingCustomiser = recipe.getToppingCustomiser();
		toppingCustomiser.setToppingStatus();
		String drinkNameTest = random.toString();
		String teaTest = random.toString();
		List<String> sweetenersTest = new ArrayList<>();
		sweetenersTest.add("Sugar");
		sweetenersTest.add("Honey");
		String sweetenerTest = sweetenersTest.get(random.nextInt(sweetenersTest.size()-1));
		double sweetenerAmtTest = random.nextDouble();
		List<String> condimentsTest = new ArrayList<>();
		condimentsTest.add("Yakult");
		condimentsTest.add("Creamer");
		String condimentTest = condimentsTest.get(random.nextInt(condimentsTest.size()-1));
		String syrupTest = random.toString();
		double syrupAmtTest = random.nextDouble();
		String juiceTest = random.toString();
		double juiceAmtTest = random.nextDouble();
		
		recipe.createRecipe(drinkNameTest, teaTest, sweetenerTest, sweetenerAmtTest, 
				condimentTest,syrupTest,syrupAmtTest, juiceTest, juiceAmtTest);
		
		assertEquals("M",cupSize.getCupSize());
		assertFalse(toppingCustomiser.getToppingStatus());
		assertEquals(drinkNameTest, recipe.getDrinkName());
	    assertEquals(teaTest, recipe.getTea());
	    assertEquals(500, recipe.getTeaVolume(),0);
	    assertEquals(sweetenerTest, recipe.getSweetener());
	    assertEquals(sweetenerAmtTest, recipe.getSweetenerAmount(),0);
	    assertEquals(condimentTest, recipe.getCondiment());
	    if (condimentTest.equals("Yakult")) {
	    	assertEquals(1.5, recipe.getCondimentAmount(),0);
	    }else if(condimentTest.equals("Creamer")) {
	    	assertEquals(5, recipe.getCondimentAmount(),0);
	    }
	    assertEquals(syrupTest, recipe.getSyrup());
	    assertEquals(syrupAmtTest, recipe.getSyrupAmount(),0);
	    assertEquals(juiceTest, recipe.getJuice());
	    assertEquals(juiceAmtTest, recipe.getJuiceAmount(),0);
		
	}
	
	@Test
	public void testDeleteRecipe() {
		Random random = new Random();
		String drinkNameTest = random.toString();
		List<Recipe> recipes = new ArrayList<>();
		
		Mockito.when(recipeRepo.findbyDrinkName(drinkNameTest)).thenReturn(recipes);
		
		recipeService.deleteRecipeByDrinkName(drinkNameTest);
		
		Mockito.verify(recipeRepo,Mockito.times(1)).deleteAll(recipes);
	}
}
