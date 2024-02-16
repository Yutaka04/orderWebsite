package fdmgroup.OrderWebsite.model.store;

import java.time.LocalDateTime;

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
	@Column(name = "OrderStatus")
	private String orderStatus;
	@Column(name = "OrderTime")
	private LocalDateTime orderTime;
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

	public int getOrderRecipeId() {
		return orderRecipeId;
	}

	public void setOrderRecipeId(int orderRecipeId) {
		this.orderRecipeId = orderRecipeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public double getTeaVolume() {
		return teaVolume;
	}

	public void setTeaVolume(double teaVolume) {
		this.teaVolume = teaVolume;
	}

	public String getSweetener() {
		return sweetener;
	}

	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}

	public double getSweetenerAmount() {
		return sweetenerAmount;
	}

	public void setSweetenerAmount(double sweetenerAmount) {
		this.sweetenerAmount = sweetenerAmount;
	}

	public String getCondiment() {
		return condiment;
	}

	public void setCondiment(String condiment) {
		this.condiment = condiment;
	}

	public double getCondimentAmount() {
		return condimentAmount;
	}

	public void setCondimentAmount(String condiment, double condimentAmt, double iceModifier, double toppingModifier) {
		if(getCondiment().equals("Creamer")) {
			this.condimentAmount = condimentAmt*(1+iceModifier+toppingModifier);
		}else {
			this.condimentAmount = condimentAmt;
		}
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public boolean isLessTopping() {
		return lessTopping;
	}

	public void setLessTopping(boolean lessTopping) {
		this.lessTopping = lessTopping;
	}

	public double getToppingMass() {
		return toppingMass;
	}

	public void setToppingMass(double toppingMass) {
		this.toppingMass = toppingMass;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public double getSyrupAmount() {
		return syrupAmount;
	}

	public void setSyrupAmount(double syrupAmount) {
		this.syrupAmount = syrupAmount;
	}

	public String getJuice() {
		return juice;
	}

	public void setJuice(String juice) {
		this.juice = juice;
	}

	public double getJuiceAmount() {
		return juiceAmount;
	}

	public void setJuiceAmount(double juiceAmount) {
		this.juiceAmount = juiceAmount;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public String getRecipeSize() {
		return recipeSize;
	}

	public void setRecipeSize() {
		if(isToppingStatus() == true && getCupSize().equals("M")) {
			this.recipeSize = "S";
		}else if(isToppingStatus() == false && getCupSize().equals("L")) {
			this.recipeSize= "L";
		}else {
			this.recipeSize= "M";
		}
	}

	public double getSweetenerModifier() {
		return sweetenerModifier;
	}

	public void setSweetenerModifier(double sweetenerModifier) {
		this.sweetenerModifier = sweetenerModifier;
	}

	public double getIceLevelModifier() {
		return iceLevelModifier;
	}

	public void setIceLevelModifier(double iceLevelModifier) {
		this.iceLevelModifier = iceLevelModifier;
	}

	public double getToppingModifier() {
		return toppingModifier;
	}

	public void setToppingModifier(double toppingModifier) {
		this.toppingModifier = toppingModifier;
	}

	public boolean isToppingStatus() {
		return toppingStatus;
	}

	public void setToppingStatus(boolean toppingStatus) {
		this.toppingStatus = toppingStatus;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
