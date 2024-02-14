package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Recipe;


public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	Optional<Drink> findbyDrinkName(String drinkName);
}
