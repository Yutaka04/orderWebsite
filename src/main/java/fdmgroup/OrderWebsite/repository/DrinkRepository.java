package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	Optional<Drink> findByDrinkName(String drinkName);
	
	
}
