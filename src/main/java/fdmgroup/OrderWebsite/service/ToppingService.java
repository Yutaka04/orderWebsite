package fdmgroup.OrderWebsite.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.ToppingRepository;

/* 
 * This generates a list of topping that contains the topping name and its price for each cup size.
 * @author = Danny
 */

@Service("toppingService")
public class ToppingService {
	
	@Autowired
	private ToppingRepository toppingRepo;
	
	private static final Logger log = LogManager.getLogger(ToppingService.class);
	
	/**
     * Initialise the topping list if it has not happened.
     */
	public void initialiseToppingList() {
		addTopping("N.A.",0,0);
		addTopping("Jumbo Pearl",1,1);
		addTopping("Aloe Vera",1.2,1.6);
		addTopping("Aiyu",1.2,1.6);
		addTopping("Konjac Ball",1.2,1.6);
		addTopping("Coffee Jelly",1,1);
		addTopping("Grass Jelly",1.2,1.6);
	}
	
	/**
     * Save a new Topping with the specified details.
     * @param toppingName The name of the topping.
     * @param priceMedium--> The price of the topping in medium cup.
     * @param priceLarge --> The price of the topping in large cup.
     */
	public void addTopping(String toppingName, double priceMedium, double priceLarge) {
		Topping topping = new Topping(toppingName, priceMedium, priceLarge);
		if (toppingRepo.findByToppingName(toppingName).isEmpty()) {
			toppingRepo.save(topping);
			log.info("ToppingSuccess: Topping:{}, Medium Price:{}, Large Price:{} added.".formatted(toppingName, priceMedium,priceLarge));
		}else {
			log.error("ToppingError: {} already existed.".formatted(toppingName));
		}
	}
	
	/**
     * Retrieves a specific price based on the cup size and the topping name.
     * @param toppingName --> The name of the topping.
     * @param cupSize --> The cup size.
     * @return double --> The price of the topping for the given cup size.
     */
	public double getPriceByToppingNameAndCupSize(String toppingName, String cupSize) {
		for(Topping t:toppingRepo.findAll()) {
			if(t.getToppingName().equals(toppingName)) {
				if (cupSize.equals("M")) {
					log.info("ToppingSuccess: {} found in Topping Menu; {} returned.".formatted(toppingName,t.getPriceMedium()));
					return t.getPriceMedium();
				}else {
					log.info("ToppingSuccess: {} found in Topping Menu; {} returned.".formatted(toppingName,t.getPriceLarge()));
					return t.getPriceLarge();
				}
			}
		}
		log.error("ToppingError: {} not found in Topping Menu.".formatted(toppingName));
		return 0;
		
	}
	
	
	public List<Topping> getAllToppings(){
		log.info("ToppingSuccess: Topping Menu retrieved");
		return toppingRepo.findAll();
	}
}
