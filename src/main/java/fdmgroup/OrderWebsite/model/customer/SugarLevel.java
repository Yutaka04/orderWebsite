package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class that manages sugar levels, including a chart of available levels,
 * the current sugar level, and a modifier associated with the selected sugar level.
 * @author = Danny
 */
public class SugarLevel{
	private List<String> sugarLevelChart;
	private String sugarLevel;
	private double sugarModifier;
	
	/**
     * Constructs a SugarLevel object with the provided sugar level chart.
     *
     * @param sugarLevelChart The chart of available sugar levels.
     */
	public SugarLevel(List<String> sugarLevelChart) {
		super();
		this.sugarLevelChart = sugarLevelChart;
	}

	/**
     * Default constructor that initializes the sugar level chart with default values.
     */
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

	/**
     * Sets the sugar modifier based on the provided sugar level.
     * @param sugarLevel The sugar level for which to determine the modifier.
     * @return The calculated sugar modifier.
     */
	public double setSugarModifier(String sugarLevel) {
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
		return getSugarModifier();
	}
}
