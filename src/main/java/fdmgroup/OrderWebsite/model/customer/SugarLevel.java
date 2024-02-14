package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

public class SugarLevel{
	private List<String> sugarLevelChart;
	private String sugarLevel;
	private double sugarModifier;
	
	public SugarLevel(List<String> sugarLevelChart) {
		super();
		this.sugarLevelChart = sugarLevelChart;
	}

	public SugarLevel() {
		sugarLevelChart = new ArrayList<String>();
		sugarLevelChart.add("120%");
		sugarLevelChart.add("100%");
		sugarLevelChart.add("70%");
		sugarLevelChart.add("50%");
		sugarLevelChart.add("25%");
		sugarLevelChart.add("0%");
	}
	
	public List<String> getSugarLevelChart(){
		return sugarLevelChart;
	}

	public String getSugarLevel() {
		return sugarLevel;
	}
	
	public double getSugarModifier() {
		return sugarModifier;
	}

	public void setSugarModifier(String sugarLevel) {
		switch (sugarLevel) {
		case "100%":
			this.sugarModifier = 1.0;
			break;
		case "70%":
			this.sugarModifier = 0.75;
			break;
		case "50%":
			this.sugarModifier = 0.5;
			break;
		case "25%":
			this.sugarModifier = 0.25;
			break;
		case "120%":
			this.sugarModifier = 1.25;
			break;
		default:
			this.sugarModifier =0.0;
			break;
		}
	}
}
