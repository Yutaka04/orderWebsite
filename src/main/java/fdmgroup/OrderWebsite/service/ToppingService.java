package fdmgroup.OrderWebsite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fdmgroup.OrderWebsite.model.store.Topping;
import jakarta.persistence.OneToMany;

/* @author: Danny
 * This generates a list of topping that contains the topping name and its price for each cup size.
 */


@Service
public class ToppingService {
	@OneToMany(mappedBy = "toppingList" )
	private List<Topping> toppingList;
	
	public ToppingService(List<Topping> toppingList) {
		super();
		this.toppingList = toppingList;
	}
	
	public ToppingService() {
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

	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
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
		if(!getToppingList().contains(topping1)) {
			toppingList.add(topping1);
		}
		if(!getToppingList().contains(topping2)) {
			toppingList.add(topping2);
		}
	}
}
