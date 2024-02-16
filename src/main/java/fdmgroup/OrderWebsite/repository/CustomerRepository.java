package fdmgroup.OrderWebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.customer.Customer;

/**
 * Repository interface for managing Customer entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/**
     * Retrieves customer associated with a specific username.
     * @param username The username of customer.
     * @return An optional class of a customer associated with the given username.
     */
	Optional<Customer> findByUsername(String username);
}
