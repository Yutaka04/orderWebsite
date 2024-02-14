package fdmgroup.OrderWebsite.model.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

/* @author: Danny
 * This generates a list of topping that contains the topping name and its price for each cup size.
 */


@Entity
public class ToppingList {
	@OneToMany(mappedBy = "toppingList" )
	private List<Topping> toppingList;
	
	public ToppingList(List<Topping> toppingList) {
		super();
		this.toppingList = toppingList;
	}
	
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
	
	public Optional<Topping> getToppingByToppingName(String toppingName) {
		Optional<Topping> topping = Optional.empty();
		for(Topping t:toppingList) {
			if(t.getToppingName().equals(toppingName)) {
				topping = Optional.of(t);
			}
		}
		return topping;
	}
	
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
