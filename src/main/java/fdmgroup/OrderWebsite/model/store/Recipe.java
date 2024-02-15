package fdmgroup.OrderWebsite.model.store;

import java.util.Optional;

import fdmgroup.OrderWebsite.model.customer.CupSize;
import fdmgroup.OrderWebsite.model.customer.ToppingCustomiser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

/**
 * Represents a recipe for creating a drink, specifying details such as
 * ingredients, sizes, and customization options.
 * @Author: Danny
 */

@Entity
@Table(name = "Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recipeID")
	private int recipeId;
	@Column(name = "Drink_Name")
	private String drinkName;
	@Column(name = "Recipe_Size")
	private String recipeSize;
	@Column(name = "Liquid_Type")
	private String tea;
	@Column(name = "Volume")
	private double teaVolume;
	@Column(name = "Sweetener")
	private String sweetener;
	@Column(name = "Sweetener_Amount")
	private double sweetenerAmount;
	@Column(name = "Condiment")
	private String condiment;
	@Column(name = "Condiment_Amount")
	private double condimentAmount;
	@Column(name = "Topping_Mass")
	private double toppingMass;
	@Column(name = "Syrup_Name")
	private String syrup;
	@Column(name = "Syrup_Amount")
	private double syrupAmount;
	@Column(name = "Juice_Name")
	private String juice;
	@Column(name = "Juice_Amount")
	private double juiceAmount;
	
	private ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
	private CupSize cupSizeSelector = toppingCustomiser.getCupSizeSelector();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_DRINKID")
	private Drink drink;
	
	/**
     * Default constructor for JPA compliance.
     */
	public Recipe() {
		super();
	}
	
	/**
     * Creates a new recipe with the specified details.
     *
     * @param drinkName       The name of the drink.
     * @param tea             The type of liquid (tea) used in the recipe.
     * @param sweetener       The sweetener used in the recipe.
     * @param sweetenerAmt    The amount of sweetener used.
     * @param condiment       The condiment used in the recipe.
     * @param syrup           The syrup used in the recipe.
     * @param syrupAmt        The amount of syrup used.
     * @param juice           The juice used in the recipe.
     * @param juiceAmt        The amount of juice used.
	 * @return 
     */
	public void createRecipe(String drinkName, String tea, String sweetener, double sweetenerAmt, 
			String condiment,String syrup,double syrupAmt, String juice, double juiceAmt) {
        this.drinkName = drinkName;
        this.sweetener = sweetener;
        this.tea = tea;
        setRecipeSize();
        setTeaVolume();
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
	
	public Drink getDrink() {
		return drink;
	}
	
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	
//	public Optional<Recipe> findRecipeByDrinkName(String drinkName){
//		Optional<Recipe> recipe = null;
//		for (Recipe r:drink.getRecipes()) {
//			if (r.getDrinkName().equals(drinkName)) {
//				recipe =  Optional.of(r);
//			}
//		}return recipe;
//	}
}
