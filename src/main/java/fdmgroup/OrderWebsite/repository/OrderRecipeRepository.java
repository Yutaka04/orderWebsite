package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.OrderRecipe;

/**
 * Repository interface for managing OrderRecipe entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */
@Repository
public interface OrderRecipeRepository extends JpaRepository<OrderRecipe, Integer>{
	/**
     * Retrieves an order recipe based on the associated order ID.
     * @param orderId The ID of the associated order.
     * @return An Optional containing an order recipe associated with the given order ID, or empty if not found.
     */
	Optional<OrderRecipe> findByOrderId(int orderId);
}
