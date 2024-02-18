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
	public void setSweetenerLevel_returnSweetenerModifierOnePointZero_when100PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Honey");
		String input = "100%";
		order.setSweetenerLevel(input);
		assertEquals(1.0,order.getSweetenerModifier(),1.0);
	}
	
	@Test
	public void setSweetenerLevel_returnSweetenerModifierOnePointTwo_when120PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Honey");
		String input = "120%";
		order.setSweetenerLevel(input);
		assertEquals(1.2,order.getSweetenerModifier(),1.2);
	}
	
	@Test
	public void setSweetenerLevel_returnSweetenerModifierZeroPointSevenFive_when70PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Honey");
		String input = "70%";
		order.setSweetenerLevel(input);
		assertEquals(0.75,order.getSweetenerModifier(),0.75);
	}
	
	@Test
	public void setSweetenerLevel_returnSweetenerModifierZeroPointFive_when50PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Honey");
		String input = "50%";
		order.setSweetenerLevel(input);
		assertEquals(0.5,order.getSweetenerModifier(),0.5);
	}
	
	@Test
	public void setSweetenerLevel_returnTrueAndSweetenerModifierZeroPointTwoFive_when25PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Honey");
		String input = "25%";
		order.setSweetenerLevel(input);
		assertEquals(0.25,order.getSweetenerModifier(),0.25);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierZeroPointZero_when100PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "100%";
		order.setSweetenerLevel(input);
		assertEquals(1.0,order.getSweetenerModifier(),1.0);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierOnePointTwo_when120PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "120%";
		order.setSweetenerLevel(input);
		assertEquals(1.2,order.getSweetenerModifier(),1.2);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierZeroPointSevenFive_when70PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "70%";
		order.setSweetenerLevel(input);
		assertEquals(0.75,order.getSweetenerModifier(),0.75);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierZeroPointFive_when50PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "50%";
		order.setSweetenerLevel(input);
		assertEquals(0.5,order.getSweetenerModifier(),0.5);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierZeroPointTwoFive_when25PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "25%";
		order.setSweetenerLevel(input);
		assertEquals(0.25,order.getSweetenerModifier(),0.25);
	}
	
	@Test
	public void setSweetenerModifier_returnSweetenerModifierZeroPointZero_when0PercentCalled(){
		CustomerOrder order = new CustomerOrder();
		order.setSweetener("Sugar");
		String input = "0%";
		order.setSweetenerLevel(input);
		assertEquals(0.0,order.getSweetenerModifier(),0.0);
	}
}
