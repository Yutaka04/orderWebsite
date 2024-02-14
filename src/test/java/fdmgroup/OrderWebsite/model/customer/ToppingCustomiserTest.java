package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.customer.SugarLevel;
import fdmgroup.OrderWebsite.model.store.ToppingList;

public class ToppingCustomiserTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//To test if the table instantiated is the same as designed
	@Test
	public void containsTopping_returnFalse_whenToppingIsNull() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		String toppingTest = null;
		toppingCustomiser.setToppingName(toppingTest);
		
		assertEquals(toppingCustomiser.getToppingStatus(), false);
	}
	
	@Test
	public void containTopping_returnTrue_whenToppingIsNotNull() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		
		assertTrue(toppingCustomiser.getToppingStatus());
	}
	
	@Test
	public void setLessTopping_returnGetLessToppingFalseAndToppingModifierZeroPointZero_whenToppingIsGrassJelly() {
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		toppingCustomiser.setToppingName("Grass Jelly");
		toppingCustomiser.setLessTopping();
		
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals(0.0, toppingCustomiser.getToppingModifer(),0.0);
	}

	@Test
	public void setLessTopping_returnGetLessToppingFalseAndToppingModifierZeroPointZero_whenToppingIsNUll() {
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		toppingCustomiser.setLessTopping();
		
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals(0.0, toppingCustomiser.getToppingModifer(),0.0);
	}

	@Test
	public void setLessTopping_returnGetLessToppingTrueAndToppingModifierZeroPointOne_whenToppingIsAllButGrassJelly() {
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		ToppingList toppingList = new ToppingList();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setLessTopping();
		
		assertTrue(toppingCustomiser.getLessTopping());
		assertEquals(0.1, toppingCustomiser.getToppingModifer(),0.0);
	}
}
