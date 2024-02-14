package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

public class HoneyLevel {
	private List<String> honeyLevelChart;
	private String honeyLevel;
	private double honeyModifier;
	
	public HoneyLevel(List<String> honeyLevelChart) {
		super();
		this.honeyLevelChart = honeyLevelChart;
	}

	public HoneyLevel() {
		honeyLevelChart = new ArrayList<String>();
		honeyLevelChart.add("120%");
		honeyLevelChart.add("100%");
		honeyLevelChart.add("70%");
		honeyLevelChart.add("50%");
		honeyLevelChart.add("25%");
	}
	
	public List<String> getHoneyLevelChart(){
		return honeyLevelChart;
	}

	public String getHoneyLevel() {
		return honeyLevel;
	}

	public void setHoneyLevel(String honeyLevel) {
		this.honeyLevel = honeyLevel;
	}
	
	public double getHoneyModifier() {
		return honeyModifier;
	}

	public double setHoneyModifier(String honeyLevel) {
		switch (honeyLevel) {
		case "100%":
			this.honeyModifier = 1.0;
			break;
		case "70%":
			this.honeyModifier = 0.75;
			break;
		case "50%":
			this.honeyModifier = 0.5;
			break;
		case "120%":
			this.honeyModifier = 1.25;
			break;
		default:
			this.honeyModifier =0.25;
			break;
		}
		return getHoneyModifier();
	}
}
