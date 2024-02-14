package fdmgroup.OrderWebsite.model.store;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import fdmgroup.OrderWebsite.model.store.ToppingList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

/* 
 * Represents a topping that can be added to a beverage, 
 * specifying details such as name, cup size compatibility, and price.
 * @author: Danny
*/

@Entity
@Table(name = "Table")
public class Topping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int toppingNameId;
	private String toppingName;
	private String cupSize;
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ToppingList toppingList;

	/**
     * Constructs a new Topping with the specified details.
     * @param toppingName The name of the topping.
     * @param cupSize     The cup size compatibility of the topping.
     * @param price       The price of the topping.
     */
	public Topping(String toppingName, String cupSize, double price) {
		super();
		setToppingName(toppingName);
		setCupSize(cupSize);
		setPrice(price);
	}

	public int getToppingNameId() {
		return toppingNameId;
	}
	
	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
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

	public ToppingList getToppingList() {
		return toppingList;
	}

	public void setToppingList(ToppingList toppingList) {
		this.toppingList = toppingList;
	}
	
}
