package fdmgroup.OrderWebsite.model.customer;

import java.time.LocalDateTime;

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
@Table(name = "`CustomerOrder`")
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private int orderId;
	@Column(name = "OrderStatus")
	private String orderStatus;
	@Column(name = "OrderTime")
	private LocalDateTime orderTime;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Cup_Size")
	private String cupSize;
	@Column(name = "Sweetener_Level")
	private String sweetenerLevel;
	@Column(name = "Ice_Level")
	private String iceLevel;
	@Column(name = "Toppings_Present?")
	private boolean toppingStatus;
	@Column(name = "Topping_Name")
	private String toppingName;
	@Column(name = "Less_Topping?")
	private boolean lessTopping;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "toppingId")
	private Topping topping;
	
	public CustomerOrder() {
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

	public String getSweetenerLevel() {
		return sweetenerLevel;
	}

	public void setSweetenerLevel(String sweetenerLevel) {
		this.sweetenerLevel = sweetenerLevel;
	}



	public String getIceLevel() {
		return iceLevel;
	}

	public void setIceLevel(String iceLevel) {
		this.iceLevel = iceLevel;
	}


	public boolean isToppingStatus() {
		return toppingStatus;
	}

	/**
     * Sets the topping status based on whether a topping is selected.
     */
	public void setToppingStatus() {
		if(getToppingName().equals("N.A.")) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
