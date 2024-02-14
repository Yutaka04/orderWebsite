package fdmgroup.OrderWebsite.model.customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CupSizeTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void CupSize_returnM_whenCalled() {
		CupSize cupSizeSelector = new CupSize();
		assertEquals("M",cupSizeSelector.getCupSize());
	}
	
	@Test
	public void upSize_returnL_whenCalled() {
		CupSize cupSizeSelector = new CupSize();
		cupSizeSelector.upsize();
		assertEquals("L",cupSizeSelector.getCupSize());
	}

}
