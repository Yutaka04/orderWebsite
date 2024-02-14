package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Topping;

@Repository
public interface MenuRepository extends JpaRepository<Drink, Integer>{
	Optional<Drink> findByDrinkName(String drinkName);
	Optional<Topping> findByToppingName(String toppingName);
}
