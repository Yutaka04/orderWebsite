package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fdmgroup.OrderWebsite.model.customer.SugarLevel;

public class HoneyLevelTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//To test if the table instantiated is the same as designed
		@Test
		public void HoneyLevel_returnHoneyLevelList_whenCalled() {
			HoneyLevel honeyLevel = new HoneyLevel();
			List<String> honeyLevelTest = new ArrayList<String>();
			honeyLevelTest.add("120%");
			honeyLevelTest.add("100%");
			honeyLevelTest.add("70%");
			honeyLevelTest.add("50%");
			honeyLevelTest.add("25%");
			
			assertEquals(honeyLevel.getHoneyLevelChart(),honeyLevelTest);
		}
		
		@Test
		public void setHoneyLevel_returnHoneyModifierOnePointZero_when100PercentCalled(){
			HoneyLevel honeyLevel = new HoneyLevel();
			String input = "100%";
			honeyLevel.setHoneyLevel(input);
			assertEquals(1.0,honeyLevel.getHoneyModifier(),1.0);
		}
		
		@Test
		public void setHoneyLevel_returnHoneyModifierOnePointTwo_when120PercentCalled(){
			HoneyLevel honeyLevel = new HoneyLevel();
			String input = "120%";
			honeyLevel.setHoneyLevel(input);
			assertEquals(1.2,honeyLevel.getHoneyModifier(),1.2);
		}
		
		@Test
		public void setHoneyLevel_returnHoneyModifierZeroPointSevenFive_when70PercentCalled(){
			HoneyLevel honeyLevel = new HoneyLevel();
			String input = "70%";
			honeyLevel.setHoneyLevel(input);
			assertEquals(0.75,honeyLevel.getHoneyModifier(),0.75);
		}
		
		@Test
		public void setHoneyLevel_returnHoneyModifierZeroPointFive_when50PercentCalled(){
			HoneyLevel honeyLevel = new HoneyLevel();
			String input = "50%";
			honeyLevel.setHoneyLevel(input);
			assertEquals(0.5,honeyLevel.getHoneyModifier(),0.5);
		}
		
		@Test
		public void setHoneyLevel_returnTrueAndHoneyModifierZeroPointTwoFive_when25PercentCalled(){
			HoneyLevel honeyLevel = new HoneyLevel();
			String input = "25%";
			honeyLevel.setHoneyLevel(input);
			assertEquals(0.25,honeyLevel.getHoneyModifier(),0.25);
		}
		
}
