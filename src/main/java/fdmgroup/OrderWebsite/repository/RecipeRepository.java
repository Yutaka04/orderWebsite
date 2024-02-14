package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fdmgroup.OrderWebsite.model.store.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	Optional<Recipe> findbyDrinkName(String drinkName);
}
