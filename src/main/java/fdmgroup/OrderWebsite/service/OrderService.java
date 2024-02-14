package fdmgroup.OrderWebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
}
