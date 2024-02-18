package fdmgroup.OrderWebsite.model.store;

import java.time.LocalDateTime;

import fdmgroup.OrderWebsite.model.customer.CustomerOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents an order recipe associated with a customer's order.
 * Contains details such as drink components, toppings, and customization.
 * @author Your Name
 */
@Deprecated
@Entity
@Table(name = "`OrderRecipe`")
public class OrderRecipe {
	@Column(name = "orderRecipeId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderRecipeId;
	@Column(name = "customerId")
	private int customerId;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Column(name = "orderTime")
	private LocalDateTime orderTime;
	@Column(name = "drinkName")
	private String drinkName;
	@Column(name = "liquidType")
	private String tea;
	@Column(name = "volume")
	private double teaVolume;
	@Column(name = "sweetener")
	private String sweetener;
	@Column(name = "sweetenerAmount")
	private double sweetenerAmount;
	@Column(name = "condiment")
	private String condiment;
	@Column(name = "condimentAmount")
	private double condimentAmount;
	@Column(name = "toppingName")
	private String toppingName;
	@Column(name = "lessTopping?")
	private boolean lessTopping;
	@Column(name = "toppingMass")
	private double toppingMass;
	@Column(name = "syrupName")
	private String syrup;
	@Column(name = "syrupAmount")
	private double syrupAmount;
	@Column(name = "juiceName")
	private String juice;
	@Column(name = "juiceAmount")
	private double juiceAmount;
	private String cupSize;
	private String recipeSize;
	private double sweetenerModifier;
	private double iceLevelModifier;
	private double toppingModifier;
	private boolean toppingStatus;	
	
	@OneToOne
	@JoinColumn(name = "recipeId")
	private Recipe recipe;
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private CustomerOrder order;
	
	public OrderRecipe() {
		super();
	}

	public OrderRecipe(int customerId, String orderStatus, LocalDateTime orderTime, String drinkName, String tea,
			double teaVolume, String sweetener, double sweetenerAmount, String condiment, double condimentAmount,
			String toppingName, boolean lessTopping, double toppingMass, String syrup, double syrupAmount, String juice,
			double juiceAmount, String cupSize, String recipeSize, double sweetenerModifier, double iceLevelModifier,
			double toppingModifier, boolean toppingStatus, Recipe recipe, CustomerOrder order) {
		super();
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		this.drinkName = drinkName;
		this.tea = tea;
		this.teaVolume = teaVolume;
		this.sweetener = sweetener;
		this.sweetenerAmount = sweetenerAmount;
		this.condiment = condiment;
		this.condimentAmount = condimentAmount;
		this.toppingName = toppingName;
		this.lessTopping = lessTopping;
		this.toppingMass = toppingMass;
		this.syrup = syrup;
		this.syrupAmount = syrupAmount;
		this.juice = juice;
		this.juiceAmount = juiceAmount;
		this.cupSize = cupSize;
		this.recipeSize = recipeSize;
		this.sweetenerModifier = sweetenerModifier;
		this.iceLevelModifier = iceLevelModifier;
		this.toppingModifier = toppingModifier;
		this.toppingStatus = toppingStatus;
		this.recipe = recipe;
		this.order = order;
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

	/**
     * Sets the recipe size based on the topping status and cup size.
     */
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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
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
