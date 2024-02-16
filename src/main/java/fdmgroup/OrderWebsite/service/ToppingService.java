package fdmgroup.OrderWebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.repository.ToppingRepository;

/* 
 * This generates a list of topping that contains the topping name and its price for each cup size.
 * @author = Danny
 */

@Service
public class ToppingService {
	
	@Autowired
	private ToppingRepository toppingRepo;
	
	/**
     * Initialise the topping list if it has not happened.
     */
	public void initialiseToppingList() {
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
		Topping topping = new Topping(toppingName,priceMedium,priceLarge);
		if (toppingRepo.findByToppingName(toppingName).isEmpty()) {
			toppingRepo.save(topping);
		}else {
			System.err.println(toppingName + " already exists");
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
					return t.getPriceMedium();
				}else {
					return t.getPriceLarge();
				}
			}
		}
		return 0;
		
	}
	
}
