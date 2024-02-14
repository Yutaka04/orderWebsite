package fdmgroup.OrderWebsite.model.customer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fdmgroup.OrderWebsite.model.customer.IceLevel;

@ExtendWith(MockitoExtension.class)
public class IceLevelTest {

	
	@BeforeAll
	public void setUp() throws Exception {
	}

	
	//To test if the table instantiated is the same as designed
	@Test
	public void IceLevel_returnIceLevelList_whenCalled() {
		IceLevel iceLevel = new IceLevel();
		List<String> iceLevelTest = new ArrayList<String>();
		iceLevelTest.add("More Ice");
		iceLevelTest.add("Normal Ice");
		iceLevelTest.add("Less Ice");
		iceLevelTest.add("Little Bit Ice");
		iceLevelTest.add("No Ice");
		
		assertEquals(iceLevel.getIceLevelChart(),iceLevelTest);
	}
	
	@Test
	public void checkIceLevel_returnFalseAndIceModifierZeroPointZero_whenNormalIceCalled(){
		IceLevel iceLevel = new IceLevel();
		String input = "Normal Ice";
		iceLevel.setIceModifier(input);
		assertEquals(0.0,iceLevel.getIceModifier(),0.0);
	}
	
	@Test
	public void setIceModifier_returnMinusZeroPointOne_whenMoreIceCalled(){
		IceLevel iceLevel = new IceLevel();
		String input = "More Ice";
		iceLevel.setIceModifier(input);
		assertEquals(-0.1,iceLevel.getIceModifier(),-0.1);
	}
	
	@Test
	public void setIceModifier_returnModifierZeroPointOne_whenLessIceCalled(){
		IceLevel iceLevel = new IceLevel();
		String input = "Less Ice";
		iceLevel.setIceModifier(input);
		assertEquals(0.1,iceLevel.getIceModifier(),0.1);
	}
	
	@Test
	public void setIceModifier_returnIceModifierZeroPointTwo_whenLittleBitIceCalled(){
		IceLevel iceLevel = new IceLevel();
		String input = "Little Bit Ice";
		iceLevel.setIceModifier(input);
		assertEquals(0.2,iceLevel.getIceModifier(),0.2);
	}
	
	@Test
	public void setIceModifier_returnIceModifierZeroPointTwo_whenNoIceCalled(){
		IceLevel iceLevel = new IceLevel();
		String input = "No Ice";
		iceLevel.setIceModifier(input);
		assertEquals(0.2,iceLevel.getIceModifier(),0.2);
	}
	
}
