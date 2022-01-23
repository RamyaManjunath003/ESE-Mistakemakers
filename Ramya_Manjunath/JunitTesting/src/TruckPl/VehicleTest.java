package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	UnitTesting obj = new UnitTesting();
	String result;
	
	@Test
	// Vehicle detected without lights before opening a gap
	public void test1() {
		result = obj.vehicle(1.5, false, false);
		assertEquals("Vehicle Detected", result);
	}
	
	@Test
	// Vehicle detected with lights before opening a gap
	public void test2() {
		result = obj.vehicle(1.5, true, false);
		assertEquals("Opening Gap...", result);
	}
	
	@Test
	// Vehicle detected with lights after opening a gap
	public void test3() {
		result = obj.vehicle(1.5, true, true);
		assertEquals("Opened Gap", result);
	}
	
	@Test
	// No Vehicle detected and no gap
	public void test4() {
		result = obj.vehicle(2.5, false, false);
		assertEquals("Happy Journey!", result);
	}
	

}
