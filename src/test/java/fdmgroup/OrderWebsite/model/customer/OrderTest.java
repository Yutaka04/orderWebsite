package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.store.Drink;

public class OrderTest {
	
	
	@Test
	public void createOrder_returnOrder_whenCalled() {		
		Random random = new Random();
		Order order = new Order();
		CupSize cupSize = order.getCupSizeSelector();
		String cupSizeTest = cupSize.getCupSize();
		ToppingList toppingList = new ToppingList();
		String drinkNameTest = random.toString();
		List<String> sweetenerList = new ArrayList<>();
		sweetenerList.add("Honey");
		sweetenerList.add("Sugar");
		HoneyLevel honeyLevelSelector = order.getHoneyLevelSelector();
		SugarLevel sugarLevelSelector = order.getSugarLevelSelector();
		IceLevel iceLevelSelector = order.getIceLevelSelector();
		Menu menu = new Menu();
		List<Drink> drinks = menu.getMenu();
		String sweetenerTest = sweetenerList.get(random.nextInt(sweetenerList.size()));
		order.setSweetener(sweetenerTest);
		String sweetenerLevelTest = "25%";
		double sweetenerModifierTest = random.nextDouble();
		if (sweetenerTest.equals("Honey")) {
			sweetenerModifierTest = honeyLevelSelector.setHoneyModifier(sweetenerLevelTest);
		}else {
			sweetenerModifierTest = sugarLevelSelector.setSugarModifier(sweetenerLevelTest);
		}
		String iceLevelTest = iceLevelSelector.getIceLevelChart().get(random.nextInt(sweetenerList.size()));
		double iceLevelModifier = iceLevelSelector.setIceModifier(iceLevelTest);
		String toppingTest = toppingList.getToppingList().get(random.nextInt(toppingList.getToppingList().size())).getToppingName();
		
		Drink drink = new Drink();
		double priceTest1 = random.nextDouble();
		double priceTest2 = random.nextDouble();
		drinks.add(drink);
		drink.createDrink(drinkNameTest, priceTest1, priceTest2);
		Order orderTest = new Order();
		orderTest.createOrder(drinkNameTest, cupSizeTest, sweetenerTest, sweetenerLevelTest, iceLevelTest, toppingTest, true);
		
		assertEquals(drinkNameTest,orderTest.getDrinkName());
		assertEquals(cupSizeTest,orderTest.getCupSize());
		assertEquals(sweetenerTest,orderTest.getSweetener());
		assertEquals(sweetenerLevelTest,orderTest.getSweetenerLevel());
		assertEquals(sweetenerModifierTest,orderTest.getSweetenerModifier(),0);
		assertEquals(iceLevelTest,orderTest.getIceLevel());
		assertEquals(iceLevelModifier,orderTest.getIceLevelModifier(),0);
		assertEquals(toppingTest, orderTest.getToppingName());
		assertTrue(orderTest.getToppingCustomiser().getToppingStatus());
		assertTrue(orderTest.getToppingCustomiser().getLessTopping());
		assertEquals(0.1,orderTest.getToppingModifier(),0);
		//assertEquals(toppingList.getPriceByToppingNameAndCupSize(toppingTest, cupSizeTest),orderTest.getToppingPrice(),0);
		//assertEquals(priceTest1,orderTest.getDrinkPrice(),0);
	}
}
