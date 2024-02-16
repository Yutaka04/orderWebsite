package fdmgroup.OrderWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fdmgroup.OrderWebsite.model.customer.Customer;
import fdmgroup.OrderWebsite.model.customer.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findAllByCustomer(Customer customer);
}
