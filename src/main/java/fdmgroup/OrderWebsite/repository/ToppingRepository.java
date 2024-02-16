package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer>{
	/*
	 * "select t from Topping t where t.toppingName = ?"
	 */
	Optional<Topping> findByToppingName(String toppingName);
	
}
