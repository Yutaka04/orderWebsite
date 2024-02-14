package fdmgroup.OrderWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fdmgroup.OrderWebsite.model.store.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
}
