package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.customer.SugarLevel;
import fdmgroup.OrderWebsite.model.store.CupSize;
import fdmgroup.OrderWebsite.model.store.Recipe;
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
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setLessTopping();
		
		assertTrue(toppingCustomiser.getLessTopping());
		assertEquals(0.1, toppingCustomiser.getToppingModifer(),0.0);
	}
	
	@Test
	public void setToppingPortion_return65_whenCupSizeIsMAndToppingIsTrueAndLessToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingList toppingList = new ToppingList();
		ToppingCustomiser toppingCustomiser = new ToppingCustomiser();
		Random random = new Random();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size()-1)).getToppingName();
		toppingCustomiser.setToppingName(toppingTest);
		toppingCustomiser.setToppingStatus();
		toppingCustomiser.setLessTopping();
		recipe.setRecipeSize();
		recipe.setToppingPortion();
		
		assertEquals("S",recipe.getRecipeSize());
		assertEquals(65,recipe.getToppingPortion());
	}
	
	@Test
	public void setToppingPortion_return120_whenCupSizeIsMAndToppingIsTrueAndLessToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()-1));
		toppingSelector.setTopping(toppingTest);
		recipe.setToppingPortion();
		
		assertEquals("M",cupSizeSelector.getCupSize());
		assertEquals(120,recipe.getToppingPortion());
	}
	
	@Test
	public void setToppingPortion_return100_whenCupSizeIsLAndToppingIsTrueAndLessToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()-1));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		toppingSelector.setLessTopping();
		recipe.setToppingPortion();
		
		assertEquals("L",cupSizeSelector.getCupSize());
		assertEquals(100,recipe.getToppingPortion());
	}
	
	@Test
	public void setToppingPortion_return200_whenCupSizeIsLAndToppingIsTrueAndLessToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()-1));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setToppingPortion();
		
		assertEquals("L",cupSizeSelector.getCupSize());
		assertEquals(200,recipe.getToppingPortion());
	}
	
	@Test
	public void setToppingPortion_return0_whenCupSizeIsMAndToppingIsFalseAndLessToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setToppingPortion();
		
		assertEquals("M",cupSizeSelector.getCupSize());
		assertEquals(0,recipe.getToppingPortion());
	}
	
	@Test
	public void setToppingPortion_return0_whenCupSizeIsLAndToppingIsFalseAndLessToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setToppingPortion();
		
		assertEquals("L",cupSizeSelector.getCupSize());
		assertEquals(0,recipe.getToppingPortion());
	}
}
