package fdmgroup.SoloProject.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fdmgroup.SoloProject.store.Recipe;

class StoreRepositoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void addRecipe_returnsThreeRecipesInMenu() {
		StoreRepository storeRepo = new StoreRepository();
		Random random = new Random();
		String drinkNameTest = random.toString();
		String teaTest = random.toString();
		String sweetenerTest = "Sugar";
		String condimentTest = "";
		String syrupTest = random.toString();
		String juiceTest = random.toString();
		double in1 = random.nextDouble();
		double in2 = random.nextDouble();
		double in3 = random.nextDouble();
		double in4 = random.nextDouble();
		double in5 = random.nextDouble();
		double in6 = random.nextDouble();
		double in7 = random.nextDouble();
		double in8 = random.nextDouble();
		double in9 = random.nextDouble();
		storeRepo.addRecipes(drinkNameTest, teaTest, sweetenerTest, in1,in2,in3,condimentTest, 
				syrupTest,in4,in5,in6, juiceTest,in7,in8,in9);
		
		assertEquals(3,storeRepo.getRecipes().size());
		assertFalse(storeRepo.getRecipes().get(0).equals(storeRepo.getRecipes().get(1)));
		assertFalse(storeRepo.getRecipes().get(0).equals(storeRepo.getRecipes().get(2)));
		assertFalse(storeRepo.getRecipes().get(1).equals(storeRepo.getRecipes().get(2)));
	}

	@Test
	void searchByDrinkName_returnsRecipeInMenu() {
		StoreRepository storeRepo = new StoreRepository();
		Random random = new Random();
		String drinkNameTest = random.toString();
		String teaTest = random.toString();
		String sweetenerTest = "Sugar";
		String condimentTest = "";
		String syrupTest = random.toString();
		String juiceTest = random.toString();
		double in1 = random.nextDouble();
		double in2 = random.nextDouble();
		double in3 = random.nextDouble();
		double in4 = random.nextDouble();
		double in5 = random.nextDouble();
		double in6 = random.nextDouble();
		double in7 = random.nextDouble();
		double in8 = random.nextDouble();
		double in9 = random.nextDouble();
		storeRepo.addRecipes(drinkNameTest, teaTest, sweetenerTest, in1,in2,in3,condimentTest, 
				syrupTest,in4,in5,in6, juiceTest,in7,in8,in9);
		Optional<Recipe> recipeTest = storeRepo.searchByDrinkName(drinkNameTest);
		
		assertTrue(storeRepo.getRecipes().get(0).equals(recipeTest.get()));
	}
	
	@Test
	void deleteRecipe_returnsEmptyMenu() {
		StoreRepository storeRepo = new StoreRepository();
		Random random = new Random();
		String drinkNameTest = random.toString();
		String teaTest = random.toString();
		String sweetenerTest = "Sugar";
		String condimentTest = "";
		String syrupTest = random.toString();
		String juiceTest = random.toString();
		double in1 = random.nextDouble();
		double in2 = random.nextDouble();
		double in3 = random.nextDouble();
		double in4 = random.nextDouble();
		double in5 = random.nextDouble();
		double in6 = random.nextDouble();
		double in7 = random.nextDouble();
		double in8 = random.nextDouble();
		double in9 = random.nextDouble();
		storeRepo.addRecipes(drinkNameTest, teaTest, sweetenerTest, in1,in2,in3,condimentTest, 
				syrupTest,in4,in5,in6, juiceTest,in7,in8,in9);
		storeRepo.deleteRecipe(drinkNameTest);
		assertEquals(0,storeRepo.getRecipes().size());
		
	}
}
