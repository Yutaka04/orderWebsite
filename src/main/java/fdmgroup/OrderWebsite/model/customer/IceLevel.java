package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

/* This class contains the different ice levels customers can choose from.
*  This class also checks if the ice level chosen is normal ice or not; if it is not normal ice,
*  a modifier is included.
*  @author = Danny
*/

public class IceLevel{
	private List<String> iceLevelChart;
	private String iceLevel;
	private double iceModifier;
	
	
	/**
     * Constructs an IceLevel object with the provided ice level chart.
     * @param iceLevelChart The chart of available ice levels.
     */
	public IceLevel(List<String> iceLevelChart) {
		super();
		this.iceLevelChart = iceLevelChart;
	}

	 /**
     * Default constructor that initializes the ice level chart with default values.
     */
	public IceLevel() {
		iceLevelChart = new ArrayList<String>();
		iceLevelChart.add("More Ice");
		iceLevelChart.add("Normal Ice");
		iceLevelChart.add("Less Ice");
		iceLevelChart.add("Little Bit Ice");
		iceLevelChart.add("No Ice");
	}
	
	public List<String> getIceLevelChart(){
		return iceLevelChart;
	}

	public String getIceLevel() {
		return iceLevel;
	}
	
	public double getIceModifier() {
		return iceModifier;
	}
	
	/**
     * Sets the ice modifier based on the provided ice level.
     * @param iceLevel The ice level for which to determine the modifier.
     * @return The calculated ice modifier.
     */
	public double setIceModifier(String iceLevel) {
		switch (iceLevel) {
		case "Normal Ice":
			this.iceModifier = 0.0;
			break;
		case "More Ice":
			this.iceModifier = -0.1;
			break;
		case "Less Ice":
			this.iceModifier = 0.1;
			break;
		default:
			this.iceModifier =0.2;
			break;
		}
		return getIceModifier();
	}
	
}
