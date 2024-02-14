package fdmgroup.OrderWebsite.model.store;

import java.util.List;

import fdmgroup.OrderWebsite.model.store.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "drinkID")
	private int drinkId;
	@Column(name = "Drink Name")
	private String drinkName;
	@Column(name = "Cup Size")
	private String cupSize;
	@Column(name = "Price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "FK_RECIPEID")
	private List<Recipe> recipes;
	
	@ManyToOne
	private Menu menu;
	
	public Drink() {
		super();
	}

	public int getDrinkId() {
		return drinkId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
