package fdmgroup.OrderWebsite.model.store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import fdmgroup.OrderWebsite.model.customer.CupSize;
import fdmgroup.OrderWebsite.model.customer.ToppingCustomiser;

@ExtendWith(MockitoExtension.class)
class RecipeTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	public void setRecipeSize_returnS_whenCupSizeIsMAndToppingIsTrue() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		ToppingList toppingList = new ToppingList();
		recipe.getCupSizeSelector();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals("M",recipe.getCupSizeSelector().getCupSize());
		assertEquals("S",recipe.getRecipeSize());
	}
	
	@Test
	public void setRecipeSize_returnM_whenCupSizeIsMAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		recipe.getCupSizeSelector();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals("M",recipe.getCupSizeSelector().getCupSize());
		assertEquals("M",recipe.getRecipeSize());
	}
	
	@Test
	public void setRecipeSize_returnM_whenCupSizeIsLAndToppingIsTrue() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		ToppingList toppingList = new ToppingList();
		recipe.getCupSizeSelector();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals("L",recipe.getCupSizeSelector().getCupSize());
		assertEquals("M",recipe.getRecipeSize());
	}
	
	@Test
	public void setRecipeSize_returnL_whenCupSizeIsLAndToppingIsFalse() {
		Recipe recipe = new Recipe();
		recipe.getCupSizeSelector().upsize();;
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals("L",recipe.getCupSizeSelector().getCupSize());
		assertEquals("L",recipe.getRecipeSize());
	}
	
	@Test
	public void setCondimentAmount_return1_whenCupSizeIsMAndToppingIsTrueAndCondimentisYakult() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setCondiment("Yakult");
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(1,recipe.getCondimentAmount(),0);
		
	}
	
	@Test
	public void setCondimentAmount_return1Point5_whenCupSizeIsMAndToppingIsFalseAndCondimentisYakult() {
		Recipe recipe = new Recipe();
		recipe.getCupSizeSelector();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setRecipeSize();
		recipe.setCondiment("Yakult");
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(1.5,recipe.getCondimentAmount(),0);
	}
	
	@Test
	public void setCondimentAmount_return1Point5_whenCupSizeIsLAndToppingIsTrueAndCondimentisYakult() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.getCupSizeSelector().upsize();
		recipe.setRecipeSize();
		recipe.setCondiment("Yakult");
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(1.5,recipe.getCondimentAmount(),0);
	
	}
	
	@Test
	public void setCondimentAmount_return2_whenCupSizeIsLAndToppingIsFalseAndCondimentisYakult() {
		Recipe recipe = new Recipe();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.getCupSizeSelector().upsize();
		recipe.setRecipeSize();
		recipe.setCondiment("Yakult");
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(2,recipe.getCondimentAmount(),0);
		
	}
	
	@Test
	public void setSweetenerAmount_return1Point4_whenCupSizeIsMAndToppingIsTrueAndSweetenerIsHoney() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		double sweetenerTest = random.nextDouble();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Honey");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(1.4,recipe.getSweetenerAmount(),0);
	}
	
	@Test
	public void setSweetenerAmount_return2_whenCupSizeIsMAndToppingIsFalseAndSweetenerIsHoney() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		double sweetenerTest = random.nextDouble();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Honey");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(2,recipe.getSweetenerAmount(),0);
		
	}
	
	@Test
	public void setSweetenerAmount_return2_whenCupSizeIsLAndToppingIsTrueAndSweetenerIsHoney() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		double sweetenerTest = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Honey");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(2,recipe.getSweetenerAmount(),0);
	
	}
	
	@Test
	public void setSweetenerAmount_return2Point8_whenCupSizeIsLAndToppingIsFalseAndSweetenerIsHoney() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		double sweetenerTest = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Honey");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(2.8,recipe.getSweetenerAmount(),0);
	
	}

	@Test
	public void setSyrupAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String syrupTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSyrup(syrupTest);
		recipe.setSyrupAmount(amt1Mock);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getSyrup(),syrupTest);
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
		
	}
	
	@Test
	public void setSyrupAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String syrupTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSyrup(syrupTest);
		recipe.setSyrupAmount(amt1Mock);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getSyrup(),syrupTest);
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
		
	}
	
	@Test
	public void setSyrupAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String syrupTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSyrup(syrupTest);
		recipe.setSyrupAmount(amt1Mock);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getSyrup(),syrupTest);
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
		
	}
	
	@Test
	public void setSyrupAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String syrupTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSyrup(syrupTest);
		recipe.setSyrupAmount(amt1Mock);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getSyrup(),syrupTest);
		assertEquals(amt1Mock,recipe.getSyrupAmount(),0);
	}
	
	@Test
	public void setCondimentAmount_return3_whenCupSizeIsMAndToppingIsTrueAndCondimentIsCreamer() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setCondiment("Creamer");
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(3,recipe.getCondimentAmount(),0);
		
	}
	
	@Test
	public void setCondimentAmount_return4_whenCupSizeIsMAndToppingIsFalseAndCondimentIsCreamer() {
		Recipe recipe = new Recipe();
		recipe.getCupSizeSelector();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setRecipeSize();
		recipe.setCondiment("Creamer");
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(4,recipe.getCondimentAmount(),0);
	}
	
	@Test
	public void setCondimentAmount_return4_whenCupSizeIsLAndToppingIsTrueAndCondimentIsCreamer() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.getCupSizeSelector().upsize();
		recipe.setRecipeSize();
		recipe.setCondiment("Creamer");
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(4,recipe.getCondimentAmount(),0);
	}
	
	@Test
	public void setCondimentAmount_return6_whenCupSizeIsLAndToppingIsFalseAndCondimentIsCreamer() {
		Recipe recipe = new Recipe();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.getCupSizeSelector().upsize();
		recipe.setRecipeSize();
		recipe.setCondiment("Creamer");
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(6,recipe.getCondimentAmount(),0);
	}
	
	@Test
	public void setTea_return350_whenCupSizeIsMAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String teaTest = random.toString();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setTea(teaTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(350,recipe.getTeaVolume(),0);
		
	}
	
	@Test
	public void setTeaVolume_return500_whenCupSizeIsMAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String teaTest = random.toString();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setTea(teaTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(500,recipe.getTeaVolume(),0);
		
	}
	
	@Test
	public void setTeaVolume_return500_whenCupSizeIsLAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String teaTest = random.toString();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setTea(teaTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(500,recipe.getTeaVolume(),0);
	}
	
	@Test
	public void setTeaVolume_return700_whenCupSizeIsLAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String teaTest = random.toString();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setTea(teaTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(700,recipe.getTeaVolume(),0);
	}
	
	@Test
	public void setSweetenerAmountreturnAmt1Mock_whenCupSizeIsMAndToppingIsTrueAndSweetenerIsSugar() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		double sweetenerTest = random.nextDouble();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Sugar");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(sweetenerTest,recipe.getSweetenerAmount(),0);
		
	}
	
	@Test
	public void setSweetenerAmountreturnAmt1Mock_whenCupSizeIsMAndToppingIsFalseAndSweetenerIsSugar() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		double sweetenerTest = random.nextDouble();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Sugar");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(sweetenerTest,recipe.getSweetenerAmount(),0);
	}
	
	@Test
	public void setSweetenerAmountreturnAmt1Mock_whenCupSizeIsLAndToppingIsTrueAndSweetenerIsSugar() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		double sweetenerTest = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Sugar");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(sweetenerTest,recipe.getSweetenerAmount(),0);
	}
	
	@Test
	public void setSweetenerAmountreturnAmt1Mock_whenCupSizeIsLAndToppingIsFalseAndSweetenerIsSugar() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		double sweetenerTest = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setSweetener("Sugar");
		recipe.setSweetenerAmount(sweetenerTest);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(sweetenerTest,recipe.getSweetenerAmount(),0);
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String juiceTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setJuice(juiceTest);
		recipe.setJuiceAmount(amt1Mock);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("S", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getJuice(),juiceTest);
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
		
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsMAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String juiceTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setJuice(juiceTest);
		recipe.setJuiceAmount(amt1Mock);
		
		assertEquals("M", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getJuice(),juiceTest);
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsTrue() {
		Random random = new Random();
		ToppingList toppingList = new ToppingList();
		Recipe recipe = new Recipe();
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		String juiceTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingName(toppingTest);
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setJuice(juiceTest);
		recipe.setJuiceAmount(amt1Mock);
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("M", recipe.getRecipeSize());
		assertTrue(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getJuice(),juiceTest);
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
	
	@Test
	public void setJuiceAmount_returnAmt1Mock_whenCupSizeIsLAndToppingIsFalse() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		String juiceTest = random.toString();
		double amt1Mock = random.nextDouble();
		recipe.getCupSizeSelector().upsize();
		recipe.getToppingCustomiser().setToppingStatus();
		recipe.setRecipeSize();
		recipe.setJuice(juiceTest);
		recipe.setJuiceAmount(amt1Mock);
		
		
		assertEquals("L", recipe.getCupSizeSelector().getCupSize());
		assertEquals("L", recipe.getRecipeSize());
		assertFalse(recipe.getToppingCustomiser().getToppingStatus());
		assertEquals(recipe.getJuice(),juiceTest);
		assertEquals(amt1Mock,recipe.getJuiceAmount(),0);
	}
	
	@Test
	public void createRecipe_returnRecipe_whenCalled() {
		Random random = new Random();
		Recipe recipe = new Recipe();
		CupSize cupSize = recipe.getCupSizeSelector();
		ToppingCustomiser toppingCustomiser = recipe.getToppingCustomiser();
		toppingCustomiser.setToppingStatus();
		String drinkNameTest = random.toString();
		String teaTest = random.toString();
		List<String> sweetenersTest = new ArrayList<>();
		sweetenersTest.add("Sugar");
		sweetenersTest.add("Honey");
		String sweetenerTest = sweetenersTest.get(random.nextInt(sweetenersTest.size()-1));
		double sweetenerAmtTest = random.nextDouble();
		List<String> condimentsTest = new ArrayList<>();
		condimentsTest.add("Yakult");
		condimentsTest.add("Creamer");
		String condimentTest = condimentsTest.get(random.nextInt(condimentsTest.size()-1));
		String syrupTest = random.toString();
		double syrupAmtTest = random.nextDouble();
		String juiceTest = random.toString();
		double juiceAmtTest = random.nextDouble();
		
		recipe.createRecipe(drinkNameTest, teaTest, sweetenerTest, sweetenerAmtTest, 
				condimentTest,syrupTest,syrupAmtTest, juiceTest, juiceAmtTest);
		
		assertEquals("M",cupSize.getCupSize());
		assertFalse(toppingCustomiser.getToppingStatus());
		assertEquals(drinkNameTest, recipe.getDrinkName());
        assertEquals(teaTest, recipe.getTea());
        assertEquals(500, recipe.getTeaVolume(),0);
        assertEquals(sweetenerTest, recipe.getSweetener());
        assertEquals(sweetenerAmtTest, recipe.getSweetenerAmount(),0);
        assertEquals(condimentTest, recipe.getCondiment());
        if (condimentTest.equals("Yakult")) {
        	assertEquals(1.5, recipe.getCondimentAmount(),0);
        }else if(condimentTest.equals("Creamer")) {
        	assertEquals(5, recipe.getCondimentAmount(),0);
        }
        assertEquals(syrupTest, recipe.getSyrup());
        assertEquals(syrupAmtTest, recipe.getSyrupAmount(),0);
        assertEquals(juiceTest, recipe.getJuice());
        assertEquals(juiceAmtTest, recipe.getJuiceAmount(),0);
		
	}
}
