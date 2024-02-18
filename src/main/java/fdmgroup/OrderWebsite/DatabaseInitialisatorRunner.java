package fdmgroup.OrderWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fdmgroup.OrderWebsite.service.MenuService;

@Component
public class DatabaseInitialisatorRunner implements CommandLineRunner{
	@Autowired
	private MenuService menuService;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		menuService.initialiseMenu();
		
	}

}
