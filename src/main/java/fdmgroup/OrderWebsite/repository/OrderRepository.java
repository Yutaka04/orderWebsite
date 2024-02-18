package fdmgroup.OrderWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.CustomerOrder;

/**
 * Repository interface for managing CustomerOrder entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Integer>{
	
	/**
     * Retrieves a list of all orders associated with a specific customer.
     * @param customer The customer entity for whom orders should be retrieved.
     * @return A list of orders associated with the given customer.
     */
	List<CustomerOrder> findAllByCustomer(Customer customer);
}
