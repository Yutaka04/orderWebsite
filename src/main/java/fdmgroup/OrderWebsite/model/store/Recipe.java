package fdmgroup.OrderWebsite.model.store;

import fdmgroup.OrderWebsite.model.customer.CupSize;
import fdmgroup.OrderWebsite.model.customer.ToppingCustomiser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recipeID")
	private int recipeId;
	@Column(name = "Drink Name")
	private String drinkName;
	@Column(name = "Recipe Size")
	private String recipeSize;
	@Column(name = "Liquid Type")
	private String tea;
	@Column(name = "Volume")
	private double teaVolume;
	@Column(name = "Sweetener")
	private String sweetener;
	@Column(name = "Sweetener Amount")
	private double sweetenerAmount;
	@Column(name = "Condiment")
	private String condiment;
	@Column(name = "Condiment Amount")
	private double condimentAmount;
	@Column(name = "Topping Mass")
	private int toppingPortion;
	@Column(name = "Syrup Name")
	private String syrup;
	@Column(name = "Syrup Amount")
	private double syrupAmount;
	@Column(name = "Juice Name")
	private String juice;
	@Column(name = "Juice Amount")
	private double juiceAmount;
	
	private ToppingCustomiser toppingCustomiser;
	private CupSize cupSize;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_RECIPEID")
	private Drink drink;
	
	public Recipe() {
		super();
	}
	
	public Recipe(String drinkName, String recipeSize, String tea, String sweetener, double sweetenerAmt, 
			String condiment,String syrup,double syrupAmt, String juice, double juiceAmt) {
        this.drinkName = drinkName;
        this.sweetener = sweetener;
        this.recipeSize = recipeSize;
        if(sweetener.equals("Sugar")) {
        	setSweetenerAmount(sweetenerAmt);
        }else {
        	setHoneyAmount();
        }
        this.condiment= condiment;
        if(condiment.equals("Yakult")) {
        	this.condimentAmount = setYakultBottle();
        }else if(condiment.equals("Creamer")) {
        	this.condimentAmount = setCreamerAmount();
        }
        this.syrup = syrup;
        if(!syrup.isEmpty()) {
        	setSyrupAmount(syrupAmt);
        }
        this.juice = juice;
        if(!juice.isEmpty()) {
        	setJuiceAmount(juiceAmt);
        }
    }

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public String getRecipeSize() {
		return recipeSize;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void setRecipeSize() {
		if (toppingCustomiser.getToppingStatus() == true && cupSize.equals("M")) {
			this.recipeSize = "S";
		}else if (toppingCustomiser.getToppingStatus() == false && cupSize.equals("L")){
			this.recipeSize = "L";
		}else {
			this.recipeSize = "M";
		}
	}

	public String getSweetener() {
		return sweetener;
	}

	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}

	public String getCondiment() {
		return condiment;
	}

	public void setCondiment(String condiment) {
		this.condiment = condiment;
	}

	public int getToppingPortion() {
		return toppingPortion;
	}

	public void setToppingPortion(int toppingPortion) {
		this.toppingPortion = toppingPortion;
	}

	public double setYakultBottle() {
		if(recipeSize.equals("M")) {
			return 1;
		}else if(recipeSize.equals("L")) {
			return 2;
		}else {
			return 1.5;
		}
	}

	public double setHoneyAmount() {
		if(recipeSize.equals("S")) {
			return 1.4;
		}else if(recipeSize.equals("L")) {
			return 2.8;
		}else {
			return 2.0;
		}
	}

	public void setSweetenerAmount(double sweetenerAmount) {
		this.sweetenerAmount = sweetenerAmount;
	}

	public double setCreamerAmount() {
		if(recipeSize.equals("S")) {
			return 3;
		}else if(recipeSize.equals("L")) {
			return 6;
		}else {
			return 4;
		}
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

	public void setTeaVolume() {
		if(recipeSize.equals("S")) {
			this.teaVolume = 350;
		}else if(recipeSize.equals("L")) {
			this.teaVolume = 700;
		}else {
			this.teaVolume = 500;
		}
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

	public int getRecipeId() {
		return recipeId;
	}
	
	
}
