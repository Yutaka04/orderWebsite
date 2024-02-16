package fdmgroup.OrderWebsite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;

/**
 * Repository interface for managing Recipe entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author: Your Name
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
	/**
     * Retrieves a list of recipes based on the given drink name.
     * @param drinkName The name of the drink.
     * @return A list of recipes associated with the given drink name.
     */
	List<Recipe> findbyDrinkName(String drinkName);
	
}
