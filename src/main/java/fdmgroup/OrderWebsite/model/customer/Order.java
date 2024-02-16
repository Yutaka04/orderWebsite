package fdmgroup.OrderWebsite.model.customer;

import java.time.LocalDateTime;

import fdmgroup.OrderWebsite.model.store.Menu;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.model.store.Topping;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents an order placed by a customer for a drink from the menu.
 * Each order contains details such as drink name, cup size, sweetener, toppings, etc.
 * @author = Danny
 */

@Entity
@Table(name = "Order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@Column(name = "OrderStatus")
	private String orderStatus;
	@Column(name = "OrderTime")
	private LocalDateTime orderTime;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Cup_Size")
	private String cupSize;
	@Column(name = "Sweetener")
	private String sweetener;
	@Column(name = "Sweetener_Level")
	private String sweetenerLevel;
	@Column(name = "Sweetener_Modifier")
	private double sweetenerModifier;
	@Column(name = "Ice_Level")
	private String iceLevel;
	@Column(name = "Ice_Level_Modifier")
	private double iceLevelModifier;
	@Column(name = "Toppings_Present?")
	private boolean toppingStatus;
	@Column(name = "Topping_Name")
	private String toppingName;
	@Column(name = "Less_Topping?")
	private boolean lessTopping;
	@Column(name = "Topping_Modifier")
	private double toppingModifier;
	@Column(name = "Topping_Mass")
	private double toppingMass;
	
	@ManyToOne
	@JoinColumn(name= "drink_ID")
	private Menu menu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CUSTOMERID")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "FK_ORDERRECIPEID")
	private OrderRecipe orderRecipe;

	@OneToOne
	@JoinColumn(name = "FK_TOPPINGID")
	private Topping topping;
	
	private HoneyLevel honeyLevelSelector = new HoneyLevel();
	private SugarLevel sugarLevelSelector = new SugarLevel();
	private IceLevel iceLevelSelector = new IceLevel();
	
	public Order() {
		super();
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getSweetener() {
		return sweetener;
	}

	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}

	public String getSweetenerLevel() {
		return sweetenerLevel;
	}

	public void setSweetenerLevel(String sweetenerLevel) {
		this.sweetenerLevel = sweetenerLevel;
	}

	public double getSweetenerModifier() {
		return sweetenerModifier;
	}

	
	 /**
     * Sets the sweetener modifier based on the selected sweetener and its level.
     * @param sweetener      The type of sweetener (e.g., "Honey", "Sugar").
     * @param sweetenerLevel The level of sweetener chosen.
     */
	public void setSweetenerModifier(String sweetener, String sweetenerLevel) {
		if(sweetener.equals("Honey")) {
			this.sweetenerModifier = honeyLevelSelector.setHoneyModifier(sweetenerLevel);
		}else if(sweetener.equals("Sugar")) {
			this.sweetenerModifier = sugarLevelSelector.setSugarModifier(sweetenerLevel);
		}
	}

	public String getIceLevel() {
		return iceLevel;
	}

	public void setIceLevel(String iceLevel) {
		this.iceLevel = iceLevel;
	}

	public double getIceLevelModifier() {
		return iceLevelModifier;
	}

	/**
     * Sets the ice level modifier based on the selected ice level.
     * @param iceLevel The chosen ice level (e.g., "Regular", "Less Ice").
     */
	public void setIceLevelModifier(String iceLevel) {
		this.iceLevelModifier = iceLevelSelector.setIceModifier(iceLevel);
	}

	public boolean isToppingStatus() {
		return toppingStatus;
	}

	/**
     * Sets the topping status based on whether a topping is selected.
     */
	public void setToppingStatus() {
		if(!getToppingName().isEmpty()) {
			this.toppingStatus = false;
		}else {
			this.toppingStatus = true;
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

	public double getToppingModifier() {
		return toppingModifier;
	}

	/**
     * Sets the topping modifier based on the selected topping and customization.
     */
	public void setToppingModifier() {
		if (isLessTopping() == true && !getToppingName().equals("Grass Jelly")) {
			this.toppingModifier = 0.1;
			System.out.println("Less topping portion selected.");
		}else if(isLessTopping() == true && getToppingName().equals("Grass Jelly")) {
			this.toppingModifier = 0.0;
			System.out.println("Grass Jelly Portion cannot be customised.");
		}else {
			System.out.println("No topping selected.");
			this.toppingModifier = 0.0;
		}
	}		

	public double getToppingMass() {
		return toppingMass;
	}

	/**
     * Sets the topping mass based on cup size, topping status, and customization.
     * @param cupSize        The size of the cup (e.g., "M", "L").
     * @param isToppingStatus The status indicating if a topping is present.
     * @param lessTopping     The status indicating if less topping is chosen.
     */
	public void setToppingMass(String cupSize,boolean isToppingStatus,boolean lessTopping) {
		if(isToppingStatus() == false) {
			this.toppingMass = 0;
		}else {
			if(isLessTopping() == true) {
				if(cupSize.equals("M")) {
					this.toppingMass = 65;
				}else {
					this.toppingMass = 100;
				}
			}else {
				if(cupSize.equals("M")) {
					this.toppingMass = 120;
				}else {
					this.toppingMass = 200;
				}
			}
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderRecipe getOrderRecipe() {
		return orderRecipe;
	}

	public void setOrderRecipe(OrderRecipe orderRecipe) {
		this.orderRecipe = orderRecipe;
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

	public void setOrderTime() {
		this.orderTime = LocalDateTime.now();
	}
	
	
}
