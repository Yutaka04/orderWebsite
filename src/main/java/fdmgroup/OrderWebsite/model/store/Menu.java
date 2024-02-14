package fdmgroup.OrderWebsite.model.store;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Menu {
	private List<Drink> menu;
	
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
