package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class GapTest {

	UnitTesting obj = new UnitTesting();
	String result;
	
	@Test
	// No lights detected after opening a gap
	public void test1() {
		result = obj.closeGap(false, true);
		assertEquals("Closing Gap...", result);
	}
	
	@Test
	// Other combinations from previous functions
	public void test2() {
		result = obj.closeGap(true, true);
		assertEquals("", result);
	}
	
	@Test
	// Other combinations from previous functions
	public void test3() {
		result = obj.closeGap(true, false);
		assertEquals("", result);
	}
	

}
