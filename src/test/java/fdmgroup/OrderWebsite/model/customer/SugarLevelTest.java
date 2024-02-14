package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SugarLevelTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//To test if the table instantiated is the same as designed
		@Test
		public void SugarLevel_returnSugarLevelList_whenCalled() {
			SugarLevel sugarLevel = new SugarLevel();
			List<String> sugarLevelTest = new ArrayList<String>();
			sugarLevelTest.add("120%");
			sugarLevelTest.add("100%");
			sugarLevelTest.add("70%");
			sugarLevelTest.add("50%");
			sugarLevelTest.add("25%");
			sugarLevelTest.add("0%");
			
			assertEquals(sugarLevel.getSugarLevelChart(),sugarLevelTest);
		}
		
		@Test
		public void setSugarModifier_returnSugarModifierZeroPointZero_when100PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "100%";
			sugarLevel.setSugarModifier(input);
			assertEquals(1.0,sugarLevel.getSugarModifier(),1.0);
		}
		
		@Test
		public void setSugarModifier_returnSugarModifierOnePointTwo_when120PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "120%";
			sugarLevel.setSugarModifier(input);
			assertEquals(1.2,sugarLevel.getSugarModifier(),1.2);
		}
		
		@Test
		public void setSugarModifier_returnSugarModifierZeroPointSevenFive_when70PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "70%";
			sugarLevel.setSugarModifier(input);
			assertEquals(0.75,sugarLevel.getSugarModifier(),0.75);
		}
		
		@Test
		public void setSugarModifier_returnSugarModifierZeroPointFive_when50PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "50%";
			sugarLevel.setSugarModifier(input);
			assertEquals(0.5,sugarLevel.getSugarModifier(),0.5);
		}
		
		@Test
		public void checkSugarLevel_returnSugarModifierZeroPointTwoFive_when25PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "25%";
			sugarLevel.setSugarModifier(input);
			assertEquals(0.25,sugarLevel.getSugarModifier(),0.25);
		}
		
		@Test
		public void checkSugarLevel_returnSugarModifierZeroPointZero_when0PercentCalled(){
			SugarLevel sugarLevel = new SugarLevel();
			String input = "0%";
			sugarLevel.setSugarModifier(input);
			assertEquals(0.0,sugarLevel.getSugarModifier(),0.0);
		}

}
