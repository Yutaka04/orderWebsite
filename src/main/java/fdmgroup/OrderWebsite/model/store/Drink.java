package fdmgroup.OrderWebsite.model.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a drink in the menu with details such as name, cup size, and price.
 * @Author: Danny
 */

@Entity
@Table(name = "`Drink`")
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "drinkId")
	private int drinkId;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Medium_Price")
	private double priceMedium;
	@Column(name = "Large_Price")
	private double priceLarge;
	
	
	@ManyToOne
	@JoinColumn(name = "menuId")
	private Menu menu;
	
	public Drink() {
		super();
	}
	
	public Drink(String drinkName, double priceMedium, double priceLarge) {
		setDrinkName(drinkName);
		setPriceMedium(priceMedium);
		setPriceLarge(priceLarge);
	}
	
	public int getDrinkId() {
		return drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}


	public double getPriceMedium() {
		return priceMedium;
	}
	
	public void setPriceMedium(double price) {
		this.priceMedium = price;
	}
	
	public double getPriceLarge() {
		return priceLarge;
	}
	
	public void setPriceLarge(double price) {
		this.priceLarge = price;
	}

	
	public Menu getMenu() {
		return menu;
	}
}
