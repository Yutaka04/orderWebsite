package fdmgroup.OrderWebsite.model.customer;

/*  
 * This class contains the cup size of the bubble tea. It contains the function to upsize the cup size
 * from M to L.
 * @author: Danny
*/

public class CupSize{
	private String size;
	
	public CupSize() {
		this.size = "M";
	}

	public String getCupSize() {
		return size;
	}

	public void setCupSize(String size) {
		this.size = size;
	}
	
	public void upsize() {
		setCupSize("L");
	}
}
