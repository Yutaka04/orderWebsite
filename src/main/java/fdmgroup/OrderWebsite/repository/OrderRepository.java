package fdmgroup.OrderWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.Order;

/**
 * Repository interface for managing Order entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	/**
     * Retrieves a list of all orders associated with a specific customer.
     * @param customer The customer entity for whom orders should be retrieved.
     * @return A list of orders associated with the given customer.
     */
	List<Order> findAllByCustomer(Customer customer);
}
