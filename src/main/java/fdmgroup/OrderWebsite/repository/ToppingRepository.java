package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Topping;

/**
 * Repository interface for managing Topping entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */
@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer>{
	/**
     * Retrieves a topping based on the topping name.
     * @param toppingName The name of the topping.
     * @return An Optional containing a topping with the given name, or empty if not found.
     */
	Optional<Topping> findByToppingName(String toppingName);
	
}
