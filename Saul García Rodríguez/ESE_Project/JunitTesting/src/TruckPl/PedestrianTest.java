package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedestrianTest {
	
	UnitTesting obj = new UnitTesting();
	String result;
	
	@Test
	// Pedestrian detected once	
	public void test1() {
		result = obj.pedestrian(true, false);
		assertEquals("Slowing Down...", result);
	}
	
	@Test
	// Pedestrian detected twice
	public void test2() {
		result = obj.pedestrian(true, true);
		assertEquals("Braking...", result);
	}
	
	@Test
	// Pedestrian never detected
	public void test3() {
		result = obj.pedestrian(false, false);
		assertEquals("Happy Journey!", result);
	}

}
