package fdmgroup.OrderWebsite.model.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

/**
 * Represents a list of toppings containing information such as topping names and prices for each cup size.
 * @Author: Danny
 */


@Entity
public class ToppingList {
	@OneToMany(mappedBy = "toppingList" )
	private List<Topping> toppingList;
	
	
	/**
     * Constructs a ToppingList with an initial list of toppings.
     * @param toppingList The list of toppings to initialize the ToppingList.
     */
	public ToppingList(List<Topping> toppingList) {
		super();
		this.toppingList = toppingList;
	}
	
	/**
     * Constructs a ToppingList with a default set of toppings.
     */
	public ToppingList() {
		toppingList = new ArrayList<>();	
		addTopping("Jumbo Pearl",1,1);
		addTopping("Aloe Vera",1.2,1.6);
		addTopping("Aiyu",1.2,1.6);
		addTopping("Konjac Ball",1.2,1.6);
		addTopping("Coffee Jelly",1,1);
		addTopping("Grass Jelly",1.2,1.6);
	}
	
	public List<Topping> getToppingList() {
		return toppingList;
	}
	
	
	/**
     * Retrieves a specific topping by its name from the ToppingList.
     * @param toppingName The name of the topping to retrieve.
     * @return An Optional containing the Topping if found, or empty if not found.
     */
	public Optional<Topping> getToppingByToppingName(String toppingName) {
		Optional<Topping> topping = Optional.empty();
		for(Topping t:toppingList) {
			if(t.getToppingName().equals(toppingName)) {
				topping = Optional.of(t);
			}
		}
		return topping;
	}
	
	/**
     * Adds a topping with the specified name and prices for medium and large cup sizes to the ToppingList.
     *
     * @param toppingName --> The name of the topping to add.
     * @param price1 --> The price of the topping for the medium cup size.
     * @param price2 --> The price of the topping for the large cup size.
     */
	public void addTopping(String toppingName, double price1, double price2) {
		Topping topping1 = new Topping(toppingName,"M",price1);
		Topping topping2 = new Topping(toppingName,"L",price2);
		if(!toppingList.contains(topping1)) {
			toppingList.add(topping1);
		}
		if(!toppingList.contains(topping2)) {
			toppingList.add(topping2);
		}
	}
}
