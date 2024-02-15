package fdmgroup.OrderWebsite.model.store;

import fdmgroup.OrderWebsite.model.customer.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order_Recipe")
public class OrderRecipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderRecipeId;
	@Column(name = "Drink Name")
	private String drinkName;
	@Column(name = "Liquid Type")
	private String tea;
	@Column(name = "Volume")
	private double teaVolume;
	@Column(name = "Sweetener")
	private String sweetener;
	@Column(name = "Sweetener Amount")
	private double sweetenerAmount;
	@Column(name = "Condiment")
	private String condiment;
	@Column(name = "Condiment Amount")
	private double condimentAmount;
	@Column(name = "Topping Name")
	private String toppingName;
	@Column(name = "Less Topping?")
	private boolean lessTopping;
	@Column(name = "Topping Mass")
	private double toppingMass;
	@Column(name = "Syrup Name")
	private String syrup;
	@Column(name = "Syrup Amount")
	private double syrupAmount;
	@Column(name = "Juice Name")
	private String juice;
	@Column(name = "Juice Amount")
	private double juiceAmount;
	private String cupSize;
	private String recipeSize;
	private double sweetenerModifier;
	private double iceLevelModifier;
	private double toppingModifier;
	private boolean toppingPresent;
	private boolean toppingStatus;
	private double drinkPrice;
	private double toppingPrice;
	
	
	@OneToOne(mappedBy = "recipe")
	private Recipe recipe;
	
	@OneToOne(mappedBy = "order")
	private Order order;
	
	private ToppingList toppingList = new ToppingList();
	
	public OrderRecipe() {
		super();
	}
	
	public void createOrderRecipe(Order order, Recipe recipe) {
		if(order.getDrinkName().equals(recipe.getDrinkName())) {
			
		}
	}
}
