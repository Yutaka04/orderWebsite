package fdmgroup.OrderWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.store.Menu;

/**
 * Repository interface for managing Menu entities in the database.
 * Extends JpaRepository for basic CRUD operations and additional query methods.
 * @author = Danny
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
