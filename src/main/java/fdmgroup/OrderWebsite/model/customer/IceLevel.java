package fdmgroup.OrderWebsite.model.customer;

import java.util.ArrayList;
import java.util.List;

/* This class contains the different ice levels customers can choose from.
*  This class also checks if the ice level chosen is normal ice or not; if it is not normal ice,
*  a modifier is included.
*/

public class IceLevel{
	private List<String> iceLevelChart;
	private String iceLevel;
	private double iceModifier;
	
	public IceLevel(List<String> iceLevelChart) {
		super();
		this.iceLevelChart = iceLevelChart;
	}

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
