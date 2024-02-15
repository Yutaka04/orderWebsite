package fdmgroup.OrderWebsite.model.customer;

import fdmgroup.OrderWebsite.model.store.Drink;
import fdmgroup.OrderWebsite.model.store.Menu;
import fdmgroup.OrderWebsite.model.store.OrderRecipe;
import fdmgroup.OrderWebsite.model.store.ToppingList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@Column(name = "Drink Name")
	private String drinkName;
	@Column(name = "Cup Size")
	private String cupSize;
	@Column(name = "Sweetener Name")
	private String sweetener;
	@Column(name = "Sweetener Level")
	private String sweetenerLevel;
	@Column(name = "Sweetener Modifier")
	private double sweetenerModifier;
	@Column(name = "Ice Level")
	private String iceLevel;
	@Column(name = "Ice Level Modifier")
	private double iceLevelModifier;
	@Column(name = "Toppings Present?")
	private boolean toppingStatus;
	@Column(name = "Topping Name")
	private String toppingName;
	@Column(name = "Less Topping?")
	private boolean lessTopping;
	@Column(name = "Topping Modifier")
	private double toppingModifier;
	@Column(name = "Topping Mass")
	private double toppingMass;
	@Column(name = "Order_Price")
	private double orderPrice;
	private double toppingPrice;
	private double drinkPrice;

	@ManyToOne
	@JoinColumn(name= "drink_ID")
	private Menu menu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CUSTOMERID")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "FK_ORDERRECIPEID")
	private OrderRecipe orderRecipe;
	
	private HoneyLevel honeyLevelSelector = new HoneyLevel();
	private SugarLevel sugarLevelSelector = new SugarLevel();
	private IceLevel iceLevelSelector = new IceLevel();
	private ToppingList toppingList = new ToppingList();
	private ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
	private CupSize cupSizeSelector = toppingCustomiser.getCupSizeSelector();
	
	public Order() {
		super();
	}
	
	public void createOrder(String drinkName, String cupSize, 
			String sweetener, String sweetenerLevel, String iceLevel,
			String toppingName, boolean lessTopping) {
		this.drinkName = drinkName;
		this.cupSize = cupSize;
		this.sweetener = sweetener;
		this.sweetenerLevel = sweetenerLevel;
		if (sweetener.equals("Sugar")) {
			this.sweetenerModifier = sugarLevelSelector.setSugarModifier(sweetenerLevel);
		}else if(sweetener.equals("Honey")) {
			this.sweetenerModifier = honeyLevelSelector.setHoneyModifier(sweetenerLevel);
		}
		this.iceLevel = iceLevel;
		this.iceLevelModifier = iceLevelSelector.setIceModifier(iceLevel);
		setToppingName(toppingName);
		getToppingCustomiser().setToppingStatus();
		this.toppingStatus = getToppingCustomiser().getToppingStatus();
		getToppingCustomiser().setLessTopping();
		this.lessTopping = getToppingCustomiser().getLessTopping();
		getToppingCustomiser().setToppingMass();
		this.toppingMass = getToppingCustomiser().getToppingMass();
		this.toppingModifier = getToppingCustomiser().getToppingModifier();
		this.drinkPrice = menu.getPricebyDrinkNameAndCupSize(drinkName, cupSize);
		this.toppingPrice = toppingList.getPriceByToppingNameAndCupSize(toppingName, cupSize);
		this.orderPrice = drinkPrice + toppingPrice;
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

	public void setCupSize() {
		this.cupSize = cupSizeSelector.getCupSize();
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

	public boolean isToppingPresent() {
		return toppingStatus;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
		toppingCustomiser.setToppingName(toppingName);
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
	
	public OrderRecipe getOrderRecipe() {
		return orderRecipe;
	}
	
	public void setOrderRecipe(OrderRecipe orderRecipe) {
		this.orderRecipe = orderRecipe;
	}
	
	public double getSweetenerModifier() {
		return sweetenerModifier;
	}
	
	public double getIceLevelModifier() {
		return iceLevelModifier;
	}
	
	public double getToppingModifier() {
		return toppingModifier;
	}

	public double getToppingMass() {
		return toppingMass;
	}
	
	public CupSize getCupSizeSelector() {
		return cupSizeSelector;
	}
	
	public HoneyLevel getHoneyLevelSelector() {
		return honeyLevelSelector;
	}
	
	public SugarLevel getSugarLevelSelector() {
		return sugarLevelSelector;
	}
	
	public IceLevel getIceLevelSelector() {
		return iceLevelSelector;
	}
	
	public ToppingCustomiser getToppingCustomiser() {
		return toppingCustomiser;
	}
	
	public String getSweetener() {
		return sweetener;
	}

	public void setSweetener(String sweetener) {
		this.sweetener = sweetener;
	}

	public void setHoneyLevelSelector(HoneyLevel honeyLevelSelector) {
		this.honeyLevelSelector = honeyLevelSelector;
	}
	
	public void setSugarLevelSelector(SugarLevel sugarLevelSelector) {
		this.sugarLevelSelector = sugarLevelSelector;
	}
	
	public void setIceLevelSelector(IceLevel iceLevelSelector) {
		this.iceLevelSelector = iceLevelSelector;
	}
	
	public void setToppingCustomiser(ToppingCustomiser toppingCustomiser) {
		this.toppingCustomiser = toppingCustomiser;
	}

	public void setCupSizeSelector(CupSize cupSizeSelector) {
		this.cupSizeSelector = cupSizeSelector;
	}

	public double getDrinkPrice() {
		return drinkPrice;
	}
	
	public double getToppingPrice() {
		return toppingPrice;
	}
	
	public double getOrderPrice() {
		return orderPrice;
	}
}
