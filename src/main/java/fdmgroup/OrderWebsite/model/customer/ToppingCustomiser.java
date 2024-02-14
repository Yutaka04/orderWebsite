package fdmgroup.OrderWebsite.model.customer;

import jakarta.persistence.Entity;

/* @Author: danny
 * Generates a list of toppings.
*/

@Entity
public class ToppingCustomiser{
	private String toppingName;
	private double toppingModifer;
	private boolean toppingStatus = false;
	private boolean lessTopping;
	private double toppingMass;
	
	private CupSize cupSizeSelector;
	
	public ToppingCustomiser() {
		super();
		this.cupSizeSelector = new CupSize();
		this.toppingName = null;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}
	
//	public void setToppingName() {
//		this.toppingName = null;
//	}
	
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
		}else {
			this.toppingStatus = true;
		}
	}
	
	public boolean getToppingStatus() {
		return toppingStatus;
	}

	public double getToppingMass() {
		return toppingMass;
	}
	
	public CupSize getCupSizeSelector() {
		return cupSizeSelector;
	}

	public void setToppingMass() {
		if(getToppingStatus() == false) {
			this.toppingMass = 0;
		}else {
			if(getLessTopping() == true) {
				if(cupSizeSelector.getCupSize().equals("M")) {
					this.toppingMass = 65;
				}else {
					this.toppingMass = 100;
				}
			}else {
				if(cupSizeSelector.getCupSize().equals("M")) {
					this.toppingMass = 120;
				}else {
					this.toppingMass = 200;
				}
			}
		}
	}
	
	
}
