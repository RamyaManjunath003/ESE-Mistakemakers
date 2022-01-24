package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedestrianTest {
	
	UnitTesting obj = new UnitTesting();
	String result;

	// Pedestrian detected once	
	@Test
	public void SlowingDown() {
		result = obj.pedestrian(true, false);
		assertEquals("Slowing Down...", result);
	}
	@Test
	public void SlowingDown_Defect() {
		result = obj.pedestrian(false, true);
		assertEquals("Slowing Down...", result);
	}

	// Pedestrian detected twice
	@Test
	public void Braking() {
		result = obj.pedestrian(true, true);
		assertEquals("Braking...", result);
	}
	@Test
	public void Braking_Defect() {
		result = obj.pedestrian(false, false);
		assertEquals("Braking...", result);
	}
	
	// Pedestrian never detected
	@Test
	public void HappyJourney() {
		result = obj.pedestrian(false, false);
		assertEquals("Happy Journey!", result);
	}
	@Test
	public void HappyJourney_Defect() {
		result = obj.pedestrian(true, true);
		assertEquals("Happy Journey!", result);
	}

}
