package fdmgroup.OrderWebsite.model.store;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
	@Column(name = "toppingId")
	private int toppingNameId;
	@Column(name = "toppingName")
	private String toppingName;
	@Column(name = "priceMedium")
	private double priceMedium;
	@Column(name = "priceLarge")
	private double priceLarge;

	/**
     * Constructs a new Topping with the specified details.
     * @param toppingName The name of the topping.
     * @param priceMedium--> The price of the topping in medium cup.
     * @param priceLarge --> The price of the topping in large cup.
     */
	public Topping(String toppingName, double priceMedium, double priceLarge) {
		super();
		setToppingName(toppingName);
		setPriceMedium(priceMedium);
		setPriceLarge(priceLarge);
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

}
