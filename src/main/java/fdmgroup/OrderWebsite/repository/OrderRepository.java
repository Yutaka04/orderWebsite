package fdmgroup.OrderWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fdmgroup.OrderWebsite.model.customer.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
