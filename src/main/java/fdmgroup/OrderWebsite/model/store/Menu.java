package fdmgroup.OrderWebsite.model.store;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 * Represents a menu containing a list of drinks available for ordering.
 * Each drink is represented by the {@link Drink} class.
 * @author = Danny
 */
@Entity
@Table(name = "Menu")
public class Menu {
	private List<Drink> menu;
	
	/**
     * Default constructor for creating a menu.
     */
	public Menu() {
		super();
	}
	
	public List<Drink> getMenu() {
		return menu;
	}

	public void setMenu(List<Drink> menu) {
		this.menu= menu;
	}
	
}
