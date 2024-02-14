package fdmgroup.OrderWebsite.model.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToppingListTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//To test if the table instantiated is the same as designed
	@Test
	public void addTopping_addsTwoToppingsOfDifferentSize_whenCalled() {
		ToppingList toppingList = new ToppingList();
		Random random = new Random();
		String toppingNameTest = random.toString();
		toppingList.addTopping(toppingNameTest, random.nextDouble(), random.nextDouble());
		int count = 0;
		Topping dummyTest = new Topping(random.toString(), "M", random.nextDouble());
		Topping testM = dummyTest;
		Topping testL = dummyTest;
		for(Topping t:toppingList.getToppingList()) {
			if(t.getToppingName().equals(toppingNameTest)) {
				if(t.getCupSize().equals("M")) {
					testM = t;
				}else if(t.getCupSize().equals("L")) {
					testL = t;
				}
				count ++;
			}
		}
		
		assertNotEquals(dummyTest, testM);
		assertNotEquals(dummyTest, testL);
		assertNotEquals(testM, testL);
		assertEquals(count,2);
		
	}
	
	@Test
	public void ToppingList_returnToppings_whenCalled() {
		ToppingList toppingList = new ToppingList();
		List<Topping> toppingsTest = new ArrayList<>();
		Topping topping1 = new Topping("Jumbo Pearl","M",1);
		Topping topping2 = new Topping("Jumbo Pearl", "L",1);
		Topping topping3 = new Topping("Aloe Vera","M",1.2);
		Topping topping4 = new Topping("Aloe Vera", "L",1.6);
		Topping topping5 = new Topping("Aiyu","M",1.2);
		Topping topping6 = new Topping("Aiyu", "L",1.6);
		Topping topping7 = new Topping("Konjac Ball","M",1.2);
		Topping topping8 = new Topping("Konjac Ball", "L",1.6);
		Topping topping9 = new Topping("Coffee Jelly","M",1);
		Topping topping10 = new Topping("Coffee Jelly", "L",1);
		Topping topping11 = new Topping("Grass Jelly","M",1.2);
		Topping topping12 = new Topping("Grass Jelly", "L",1.6);
		toppingsTest.add(topping1);
		toppingsTest.add(topping2);
		toppingsTest.add(topping3);
		toppingsTest.add(topping4);
		toppingsTest.add(topping5);
		toppingsTest.add(topping6);
		toppingsTest.add(topping7);
		toppingsTest.add(topping8);
		toppingsTest.add(topping9);
		toppingsTest.add(topping10);
		toppingsTest.add(topping11);
		toppingsTest.add(topping12);
		
		assertEquals(toppingList.getToppingList().size(),toppingsTest.size());
		for(int i = 0; i< toppingList.getToppingList().size();i++) {
			assertEquals(toppingList.getToppingList().get(i).getToppingName(),toppingsTest.get(i).getToppingName());
			assertEquals(toppingList.getToppingList().get(i).getCupSize(),toppingsTest.get(i).getCupSize());
			assertEquals(toppingList.getToppingList().get(i).getPrice(),toppingsTest.get(i).getPrice(),0);
		}
	}
		
		
}
