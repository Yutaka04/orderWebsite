package fdmgroup.OrderWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.OrderRecipe;

@Repository
public interface OrderRecipeRepository extends JpaRepository<OrderRecipe, Integer>{

}
