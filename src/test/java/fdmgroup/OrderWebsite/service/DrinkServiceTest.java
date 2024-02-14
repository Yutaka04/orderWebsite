package fdmgroup.OrderWebsite.service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;
import fdmgroup.OrderWebsite.repository.DrinkRepository;
import fdmgroup.OrderWebsite.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Unit tests for the {@link DrinkService} class.
 * @author = Danny
 */

@SpringBootTest
public class DrinkServiceTest {

    @Mock
    private DrinkRepository drinkRepository;

    @Mock
    private RecipeRepository recipeRepository;

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
        Mockito.when(drinkRepository.findbyDrinkName(drinkName)).thenReturn(Optional.of(drink));
        Mockito.when(recipeRepository.save(recipe)).thenReturn(recipe);
        // Act
        drinkService.addRecipeToDrink(drinkName, recipe);
        // Assert
        Mockito.verify(recipeRepository, Mockito.times(1)).save(recipe);
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

        Mockito.when(drinkRepository.findbyDrinkName(drinkName)).thenReturn(Optional.of(drink));
        Mockito.doNothing().when(recipeRepository).delete(recipe);
        Mockito.when(drinkRepository.save(drink)).thenReturn(drink);

        // Act
        drinkService.removeRecipeFromDrink(drinkName, recipe);

        // Assert
        Mockito.verify(recipeRepository, Mockito.times(1)).delete(recipe);
        Mockito.verify(drinkRepository, Mockito.times(1)).save(drink);
    }
}