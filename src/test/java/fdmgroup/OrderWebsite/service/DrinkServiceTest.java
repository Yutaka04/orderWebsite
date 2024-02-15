package fdmgroup.OrderWebsite.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Unit tests for the {@link DrinkService} class.
 * @author = Danny
 */

@SpringBootTest(classes = {DrinkService.class})
public class DrinkServiceTest {

	
    @MockBean
    private DrinkRepository drinkRepo;

    @MockBean
    private RecipeRepository recipeRepo;

    @InjectMocks
    private DrinkService drinkService;

    /**
     * Test case to verify that a recipe can be successfully added to a drink.
     */    
    @Test
    public void testAddRecipeToDrink() {
        // Arrange
        String drinkName = "TestDrink";
        Recipe recipe = new Recipe();
        Drink drink = new Drink();
        drink.setDrinkName(drinkName);
        Mockito.when(drinkRepo.findByDrinkName(drinkName)).thenReturn(Optional.of(drink));
        Mockito.when(recipeRepo.save(recipe)).thenReturn(recipe);
        // Act
        drinkService.addRecipeToDrink(drinkName, recipe);
        // Assert
        Mockito.verify(recipeRepo, Mockito.times(1)).save(recipe);
    }

    
    /**
     * Test case to verify that a recipe can be successfully removed from a drink.
     */
    @Test
    public void testRemoveRecipeFromDrink() {
        // Arrange
        String drinkName = "TestDrink";
        Recipe recipe = new Recipe();
        Drink drink = new Drink();
        drink.setDrinkName(drinkName);
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe);
        drink.setRecipes(recipes);

        Mockito.when(drinkRepo.findByDrinkName(drinkName)).thenReturn(Optional.of(drink));
        Mockito.doNothing().when(recipeRepo).delete(recipe);
        Mockito.when(drinkRepo.save(drink)).thenReturn(drink);

        // Act
        drinkService.removeRecipeFromDrink(drinkName, recipe);

        // Assert
        Mockito.verify(recipeRepo, Mockito.times(1)).delete(recipe);
        Mockito.verify(drinkRepo, Mockito.times(1)).save(drink);
    }
}