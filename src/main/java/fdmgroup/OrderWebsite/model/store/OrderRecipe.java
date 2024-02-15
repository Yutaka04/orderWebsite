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
	@Column(name = "Customer_ID")
	private int customerId;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Liquid_Type")
	private String tea;
	@Column(name = "Volume")
	private double teaVolume;
	@Column(name = "Sweetener")
	private String sweetener;
	@Column(name = "Sweetener_Amount")
	private double sweetenerAmount;
	@Column(name = "Condiment")
	private String condiment;
	@Column(name = "Condiment_Amount")
	private double condimentAmount;
	@Column(name = "Topping_Name")
	private String toppingName;
	@Column(name = "Less_Topping?")
	private boolean lessTopping;
	@Column(name = "Topping Mass")
	private double toppingMass;
	@Column(name = "Syrup_Name")
	private String syrup;
	@Column(name = "Syrup_Amount")
	private double syrupAmount;
	@Column(name = "Juice_Name")
	private String juice;
	@Column(name = "Juice_Amount")
	private double juiceAmount;
	private String cupSize;
	private String recipeSize;
	private double sweetenerModifier;
	private double iceLevelModifier;
	private double toppingModifier;
	private boolean toppingStatus;	
	
	@OneToOne(mappedBy = "drink")
	private Drink drink;
	
	@OneToOne(mappedBy = "order")
	private Order order;
	
	public OrderRecipe() {
		super();
	}
	
	public void createOrderRecipe(Order order, Drink drink) {
		if(order.getDrinkName().equals(drink.getDrinkName())) {
			this.customerId = order.getCustomer().getCustomerId();
			this.drinkName = order.getDrinkName();
			this.cupSize = order.getCupSize();
			this.toppingName = order.getToppingName();
			this.toppingStatus = order.isToppingPresent();
			this.sweetenerModifier = order.getSweetenerModifier();
			this.iceLevelModifier = order.getIceLevelModifier();
			this.toppingModifier = order.getToppingModifier();
			setRecipeSize(toppingStatus, cupSize);
			Recipe recipe = drink.getRecipeByRecipeSize(recipeSize);
			this.tea = recipe.getTea();
			this.teaVolume = recipe.getTeaVolume()*(1+iceLevelModifier+toppingModifier);
			this.sweetener = recipe.getSweetener();
			this.sweetenerAmount = recipe.getSweetenerAmount()*(1+iceLevelModifier+toppingModifier+sweetenerModifier);
			this.condiment = recipe.getCondiment();
			if (condiment.equals("Yakult")) {
				this.condimentAmount = recipe.getCondimentAmount();
			}else {
				this.condimentAmount = recipe.getCondimentAmount()*(1+iceLevelModifier+toppingModifier);
			}
			this.syrup = recipe.getSyrup();
			if(!syrup.isBlank()) {
				this.syrupAmount = recipe.getSyrupAmount()*(1+iceLevelModifier+toppingModifier);
			}
			this.juice = recipe.getJuice();
			if(!juice.isBlank()) {
				this.juiceAmount = recipe.getJuiceAmount()*(1+iceLevelModifier+toppingModifier);
			}
		}
	}
	
	public void setRecipeSize(boolean toppingStatus, String cupSize) {
		if(toppingStatus == true && cupSize.equals("M")) {
			this.recipeSize = "S";
		}else if(toppingStatus == false && cupSize.equals("L")) {
			this.recipeSize = "L";
		}else {
			this.recipeSize = "M";
		}
	}
}
