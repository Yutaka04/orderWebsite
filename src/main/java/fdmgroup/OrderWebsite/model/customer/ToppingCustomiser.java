package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

import fdmgroup.OrderWebsite.model.store.Topping;
import fdmgroup.OrderWebsite.model.store.ToppingList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* @Author: danny
 * Generates a list of toppings.
*/

@Entity
public class ToppingCustomiser{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int toppingNameId;
	private String toppingName;
	private double toppingModifer;
	private boolean toppingStatus;
	private boolean lessTopping;

	public ToppingCustomiser() {
		super();
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}
	
	public double getToppingModifer() {
		return toppingModifer;
	}

	public boolean getLessTopping() {
		return lessTopping;
	}

//  Allows the customer to select if they want to have less toppings or not for all toppings except Grass Jelly.
	public void setLessTopping() {
		if (getToppingStatus() == true && !getToppingName().equals("Grass Jelly")) {
			this.lessTopping = true;
			this.toppingModifer = 0.1;
			System.out.println("Less topping portion selected.");
		}else if(getToppingStatus() == true && getToppingName().equals("Grass Jelly")) {
			this.lessTopping = false;
			this.toppingModifer = 0.0;
			System.out.println("Grass Jelly Portion cannot be customised.");
		}else {
			System.out.println("No topping selected.");
			this.lessTopping = false;
			this.toppingModifer = 0.0;
		}
	}

	//Check if the order contains toppings or not.
	public void setToppingStatus() {
		if(getToppingName() == null) {
			this.toppingStatus = false;
		}
		this.toppingStatus = true;
	}
	
	public boolean getToppingStatus() {
		return toppingStatus;
	}
	
	public int getToppingNameId() {
		return toppingNameId;
	}
}
