package fdmgroup.OrderWebsite.model.store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.customer.CupSizeSelector;
import fdmgroup.OrderWebsite.model.customer.ToppingSelector;

class OrderConstructorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void setYakultBottle_return1Point5_whenCupSizeIsLAndToppingIsTrueAndLessToppingIsTrue() {
		IngredientName ingredientName = new IngredientName();
		ToppingCustomiser toppingSelector = ingredientName.getToppingSelector();
		CupSize cupSizeSelector = ingredientName.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()-1));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		toppingSelector.setLessTopping();
		ingredientName.setYakultBottle();
		
		assertEquals("L", ingredientName.getCupSize());
		assertTrue(toppingSelector.containsTopping());
		assertEquals(toppingSelector.getLessTopping(),true);
		assertEquals(1.5,ingredientName.getYakultBottle(),0);	
	}
	
	@Test
	public void setYakultBottle_return1_whenCupSizeIsMAndToppingIsTrueAndLessToppingIsTrue() {
		IngredientName ingredientName = new IngredientName();
		ToppingCustomiser toppingSelector = ingredientName.getToppingSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()-1));
		toppingSelector.setTopping(toppingTest);
		toppingSelector.setLessTopping();
		ingredientName.setYakultBottle();
		
		assertEquals("M", ingredientName.getCupSize());
		assertTrue(toppingSelector.containsTopping());
		assertEquals(toppingSelector.getLessTopping(),true);
		assertEquals(1,ingredientName.getYakultBottle(),0);
	}
}
