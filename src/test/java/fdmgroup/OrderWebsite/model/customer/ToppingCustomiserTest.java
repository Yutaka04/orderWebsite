package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.store.ToppingList;

public class ToppingCustomiserTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//To test if the table instantiated is the same as designed
	@Test
	public void containsTopping_returnFalse_whenToppingIsNull() {
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
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-2)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setLessTopping();
		
		assertTrue(toppingCustomiser.getLessTopping());
		assertEquals(0.1, toppingCustomiser.getToppingModifer(),0.0);
	}
	
	@Test
	public void setToppingMass_return65_whenCupSizeIsMAndToppingIsTrueAndLessToppingIsTrue() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-2)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setLessTopping();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingName().isBlank());
		assertTrue(toppingCustomiser.getToppingStatus());
		assertTrue(toppingCustomiser.getLessTopping());
		assertEquals("M",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(65,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.1,toppingCustomiser.getToppingModifer(),0);
	}
	
	@Test
	public void setToppingMass_return120_whenCupSizeIsMAndToppingIsTrueAndLessToppingIsFalse() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingName().isBlank());
		assertTrue(toppingCustomiser.getToppingStatus());
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals("M",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(120,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.0,toppingCustomiser.getToppingModifer(),0);
	}
	
	@Test
	public void setToppingMass_return100_whenCupSizeIsLAndToppingIsTrueAndLessToppingIsTrue() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.getCupSizeSelector().upsize();
		toppingCustomiser.setLessTopping();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingName().isBlank());
		assertTrue(toppingCustomiser.getToppingStatus());
		assertTrue(toppingCustomiser.getLessTopping());
		assertEquals("L",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(100,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.1,toppingCustomiser.getToppingModifer(),0);
	}
	
	@Test
	public void setToppingMass_return200_whenCupSizeIsLAndToppingIsTrueAndLessToppingIsFalse() {
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.getCupSizeSelector().upsize();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingName().isBlank());
		assertTrue(toppingCustomiser.getToppingStatus());
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals("L",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(200,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.0,toppingCustomiser.getToppingModifer(),0);
	}
	
	@Test
	public void setToppingMass_return0_whenCupSizeIsMAndToppingIsFalseAndLessToppingIsFalse() {
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingStatus());
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals("M",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(0,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.0,toppingCustomiser.getToppingModifer(),0);
	}
	
	@Test
	public void setToppingMass_return0_whenCupSizeIsLAndToppingIsFalseAndLessToppingIsFalse() {
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.getCupSizeSelector().upsize();
		toppingCustomiser.setToppingMass();
		
		assertFalse(toppingCustomiser.getToppingStatus());
		assertFalse(toppingCustomiser.getLessTopping());
		assertEquals("L",toppingCustomiser.getCupSizeSelector().getCupSize());
		assertEquals(0,toppingCustomiser.getToppingMass(),0);
		assertEquals(0.0,toppingCustomiser.getToppingModifer(),0);
	}
}
