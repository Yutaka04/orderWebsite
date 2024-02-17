package fdmgroup.OrderWebsite.model.customer;

import java.time.LocalDateTime;

import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.model.store.Topping;
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
	@JoinColumn(name = "orderId")
	private Customer customer;
	
	@OneToOne(mappedBy = "order")
	@JoinColumn(name = "orderId")
	private OrderRecipe orderRecipe;

	@OneToOne
	@JoinColumn(name = "orderId")
	private Topping topping;
	
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
			switch (sweetenerLevel) {
			case "100%":
				this.sweetenerModifier = 1.0;
				break;
			case "70%":
				this.sweetenerModifier = 0.75;
				break;
			case "50%":
				this.sweetenerModifier = 0.5;
				break;
			case "120%":
				this.sweetenerModifier = 1.25;
				break;
			default:
				this.sweetenerModifier =0.25;
				break;
			}
		}else if(sweetener.equals("Sugar")) {
			switch (sweetenerLevel) {
			case "100%":
				this.sweetenerModifier = 1.0;
				break;
			case "70%":
				this.sweetenerModifier = 0.75;
				break;
			case "50%":
				this.sweetenerModifier = 0.5;
				break;
			case "25%":
				this.sweetenerModifier = 0.25;
				break;
			case "120%":
				this.sweetenerModifier = 1.25;
				break;
			default:
				this.sweetenerModifier =0.0;
				break;
			}
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
		switch (iceLevel) {
		case "Normal Ice":
			this.iceLevelModifier = 0.0;
			break;
		case "More Ice":
			this.iceLevelModifier = -0.1;
			break;
		case "Less Ice":
			this.iceLevelModifier = 0.1;
			break;
		default:
			this.iceLevelModifier =0.2;
			break;
		}
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
