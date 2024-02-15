package fdmgroup.OrderWebsite.model.customer;

import jakarta.persistence.Entity;

/**
 * Represents a class that manages customization options for toppings, including the selected topping name,
 * its modifier, customization status, and the mass of toppings based on the selected options.
 * @author = Danny
 */

@Entity
public class ToppingCustomiser{
	private String toppingName;
	private double toppingModifier;
	private boolean toppingStatus = false;
	private boolean lessTopping;
	private double toppingMass;
	
	private CupSize cupSizeSelector;
	
	/**
     * Default constructor that initializes the topping customizer with default values.
     */
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
	
	public double getToppingModifier() {
		return toppingModifier;
	}

	public boolean getLessTopping() {
		return lessTopping;
	}

	 /**
     * Sets the flag indicating whether less topping is selected, and calculates the associated modifier.
     */
	public void setLessTopping() {
		if (getToppingStatus() == true && !getToppingName().equals("Grass Jelly")) {
			this.lessTopping = true;
			this.toppingModifier = 0.1;
			System.out.println("Less topping portion selected.");
		}else if(getToppingStatus() == true && getToppingName().equals("Grass Jelly")) {
			this.lessTopping = false;
			this.toppingModifier = 0.0;
			System.out.println("Grass Jelly Portion cannot be customised.");
		}else {
			System.out.println("No topping selected.");
			this.lessTopping = false;
			this.toppingModifier = 0.0;
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
	
	/**
     * Retrieves the cup size selector associated with the topping customizer.
     *
     * @return The cup size selector.
     */
	public CupSize getCupSizeSelector() {
		return cupSizeSelector;
	}
	
	 /**
     * Sets the mass of toppings based on the selected options.
     */
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
