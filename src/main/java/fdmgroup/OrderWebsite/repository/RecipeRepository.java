package fdmgroup.OrderWebsite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	List<Recipe> findbyDrinkName(String drinkName);
	
}
