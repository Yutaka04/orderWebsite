package fdmgroup.OrderWebsite.model.store;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "Price")
	private double price;
	
	@OneToMany(mappedBy = "drink")
	private List<Recipe> recipes;
	
	@ManyToOne
	private Menu menu;
	
	/**
     * Default constructor for JPA compliance.
     */
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

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<Recipe> getRecipes(){
		return recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public Recipe getRecipeByRecipeSize(String recipeSize) {
		Recipe recipe = new Recipe();
		for (Recipe r:getRecipes()) {
			if(r.getRecipeSize().equals(recipeSize)) {
				recipe = r;
			}
		}return recipe;
	}
	
}
