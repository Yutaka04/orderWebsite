package fdmgroup.OrderWebsite.model.store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import fdmgroup.OrderWebsite.model.customer.CupSizeSelector;
import fdmgroup.OrderWebsite.model.customer.ToppingCustomiser;
import fdmgroup.OrderWebsite.model.customer.ToppingSelector;

@ExtendWith(MockitoExtension.class)
class RecipeTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	
	@Test
	public void setYakultBottle_return1_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setYakultBottle();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(1,recipe.getYakultBottle(),0);
		
	}
	
	@Test
	public void setYakultBottle_return1Point5_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setYakultBottle();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(1.5,recipe.getYakultBottle(),0);
	}
	
	@Test
	public void setYakultBottle_return1Point5_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setYakultBottle();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(1.5,recipe.getYakultBottle(),0);
	}
	
	@Test
	public void setYakultBottle_return2_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setYakultBottle();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(2.0,recipe.getYakultBottle(),0);
	}
	
	@Test
	public void setHoneyAmount_return1Point4_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setHoneyAmount();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(1.4,recipe.getHoneyAmount(),0);
		
	}
	
	@Test
	public void setHoneyAmount_return2_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setHoneyAmount();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(2,recipe.getHoneyAmount(),0);
	}
	
	@Test
	public void setHoneyAmount_return2_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setHoneyAmount();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(2,recipe.getHoneyAmount(),0);
	}
	
	@Test
	public void setHoneyAmount_return2Point8_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setHoneyAmount();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(2.8,recipe.getHoneyAmount(),0);
	}

	@Test
	public void setSyrupAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setSyrup(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
		
	}
	
	@Test
	public void setSyrupAmount_returnAmt2Mock_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setSyrup(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
	}
	
	@Test
	public void setSyrupAmount_returnAmt2Mock_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setSyrup(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
	}
	
	@Test
	public void setSyrupAmount_returnAmt3Mock_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setSyrup(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
	}
	
	@Test
	public void setCreamerAmount_return3_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setCreamerAmount();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(3,recipe.getCreamerAmount(),0);
		
	}
	
	@Test
	public void setCreamerAmount_return4_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setCreamerAmount();
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(4,recipe.getCreamerAmount(),0);
	}
	
	@Test
	public void setCreamerAmount_return4_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setCreamerAmount();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(4,recipe.getCreamerAmount(),0);
	}
	
	@Test
	public void setCreamerAmount_return6_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setCreamerAmount();
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(6,recipe.getCreamerAmount(),0);
	}
	
	@Test
	public void setTea_return350_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String teaTest = random.toString();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setTea(teaTest);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(350,recipe.getTeaVolume(),0);
		
	}
	
	@Test
	public void setTeaVolume_return500_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = null;
		String teaTest = random.toString();
		toppingSelector.setTopping(toppingTest);
		recipe.setTea(teaTest);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(500,recipe.getTeaVolume(),0);
	}
	
	@Test
	public void setTeaVolume_return500_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String teaTest= random.toString();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setTea(teaTest);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(500,recipe.getTeaVolume(),0);
	}
	
	@Test
	public void setTeaVolume_return700_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		String toppingTest = null;
		String teaTest = random.toString();
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setTea(teaTest);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(700,recipe.getTeaVolume(),0);
	}
	
	@Test
	public void setSugarAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setSugarAmount(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSugarAmount(),0);
		
	}
	
	@Test
	public void setSugarAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setSugarAmount(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSugarAmount(),0);
	}
	
	@Test
	public void setSugarAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setSugarAmount(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSugarAmount(),0);
	}
	
	@Test
	public void setSugarAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setSugarAmount(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getSugarAmount(),0);
	}
	//juiceAmount
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		toppingSelector.setTopping(toppingTest);
		recipe.setJuice(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
		
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		toppingSelector.setTopping(toppingTest);
		recipe.setJuice(amt1Mock);
		
		assertEquals("M", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsTrue() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = toppingSelector.getToppings().get(random.nextInt(toppingSelector.getToppings().size()));
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setJuice(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertTrue(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		ToppingCustomiser toppingSelector = recipe.getToppingSelector();
		CupSize cupSizeSelector = recipe.getCupSizeSelector();
		Random random = new Random();
		double amt1Mock = random.nextDouble();
		String toppingTest = null;
		cupSizeSelector.upsize();
		toppingSelector.setTopping(toppingTest);
		recipe.setJuice(amt1Mock);
		
		assertEquals("L", cupSizeSelector.getCupSize());
		assertFalse(toppingSelector.getToppingStatus());
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
}
