package fdmgroup.OrderWebsite.model.store;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a drink in the menu with details such as name, cup size, and price.
 * @Author: Danny
 */

@Entity
@Table(name = "Drink")
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "drinkID")
	private int drinkId;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Cup_Size")
	private String cupSize;
	@Column(name = "Medium_Price")
	private double priceMedium;
	@Column(name = "Large_Price")
	private double priceLarge;
	
	@OneToMany(mappedBy = "drink")
	private List<Recipe> recipes;
	
	private List<Drink> menu;
	
	public Drink() {
		super();
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

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
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
	
	public List<Recipe> getRecipes(){
		return recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public List<Drink> getMenu() {
		return menu;
	}
}
