package fdmgroup.OrderWebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepo;
	
	
}
