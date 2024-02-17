package fdmgroup.OrderWebsite.model.store;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "Menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menuId")
	private int menuId;
	
	@ManyToMany
	@JoinTable(name = "menu_drink", 
			joinColumns = @JoinColumn(name = "menuId"),
			inverseJoinColumns = @JoinColumn(name = "drinkId"))
	private List<Drink> drinks;
	
	@ManyToMany
	@JoinTable(name = "menu_drink", 
			joinColumns = @JoinColumn(name = "menuId"),
			inverseJoinColumns = @JoinColumn(name = "toppingId"))
	private List<Topping> toppings;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
	
	
}
