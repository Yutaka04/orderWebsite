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
	private double toppingMass;
	@Column(name = "Syrup Name")
	private String syrup;
	@Column(name = "Syrup Amount")
	private double syrupAmount;
	@Column(name = "Juice Name")
	private String juice;
	@Column(name = "Juice Amount")
	private double juiceAmount;
	
	private ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
	private CupSize cupSizeSelector = toppingCustomiser.getCupSizeSelector();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_RECIPEID")
	private Drink drink;
	
	public Recipe() {
		super();
	}
	
	public Recipe(String drinkName, String tea, String sweetener, double sweetenerAmt, 
			String condiment,String syrup,double syrupAmt, String juice, double juiceAmt) {
        this.drinkName = drinkName;
        this.sweetener = sweetener;
        setRecipeSize();
        setSweetenerAmount(sweetenerAmt);
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
        this.toppingMass = getToppingCustomiser().getToppingMass();
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

	public void setRecipeSize() {
		if (toppingCustomiser.getToppingStatus() == true && cupSizeSelector.getCupSize().equals("M")) {
			this.recipeSize = "S";
		}else if (toppingCustomiser.getToppingStatus() == false && cupSizeSelector.getCupSize().equals("L")){
			this.recipeSize = "L";
		}else {
			this.recipeSize = "M";
		}
	}

	public String getSweetener() {
		return sweetener;
	}

	public double getSweetenerAmount() {
		return sweetenerAmount;
	}
	
	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}

	public String getCondiment() {
		return condiment;
	}

	public void setCondiment(String condiment) {
		this.condiment = condiment;
		if(condiment.equals("Yakult")) {
        	this.condimentAmount = setYakultBottle();
        }else if(condiment.equals("Creamer")) {
        	this.condimentAmount = setCreamerAmount();
        }
	}

	public double getCondimentAmount() {
		return condimentAmount;
	}
	
	public double setYakultBottle() {
		if(recipeSize.equals("S")) {
			return 1;
		}else if(recipeSize.equals("L")) {
			return 2;
		}else {
			return 1.5;
		}
	}

	public double setHoneyAmount() {
		if(getRecipeSize().equals("S")) {
			return 1.4;
		}else if(getRecipeSize().equals("L")) {
			return 2.8;
		}else {
			return 2.0;
		}
	}

	public void setSweetenerAmount(double sweetenerAmount) {
		if(sweetener.equals("Sugar")) {
        	this.sweetenerAmount = sweetenerAmount;
        }else if(sweetener.equals("Honey")){
        	this.sweetenerAmount = setHoneyAmount();
        }
	}

	public double setCreamerAmount() {
		if(getRecipeSize().equals("S")) {
			return 3;
		}else if(getRecipeSize().equals("L")) {
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
		setTeaVolume();
	}

	public double getTeaVolume() {
		return teaVolume;
	}

	public void setTeaVolume() {
		if(getRecipeSize().equals("S")) {
			this.teaVolume = 350;
		}else if(getRecipeSize().equals("L")) {
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

	public ToppingCustomiser getToppingCustomiser() {
		return toppingCustomiser;
	}

	public void setToppingCustomiser(ToppingCustomiser toppingCustomiser) {
		this.toppingCustomiser = toppingCustomiser;
	}

	public CupSize getCupSizeSelector() {
		return cupSizeSelector;
	}

	public void setCupSizeSelector(CupSize cupSizeSelector) {
		this.cupSizeSelector = cupSizeSelector;
	}
	
	
}
