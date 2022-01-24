package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	UnitTesting obj = new UnitTesting();
	String result;

	// Vehicle detected without lights before opening a gap
	@Test
	public void VehicleDetected() {
		result = obj.vehicle(1.5, false, false);
		assertEquals("Vehicle Detected", result);
	}
	@Test
	public void VehicleDetected_Defect() {
		result = obj.vehicle(1.5, true, true);
		assertEquals("Vehicle Detected", result);
	}

	// Vehicle detected with lights before opening a gap
	@Test
	public void OpeningGap() {
		result = obj.vehicle(1.5, true, false);
		assertEquals("Opening Gap...", result);
	}
	@Test
	public void OpeningGap_Defect() {
		result = obj.vehicle(1.5, false, true);
		assertEquals("Opening Gap...", result);
	}

	// Vehicle detected with lights after opening a gap
	@Test
	public void OpenedGap() {
		result = obj.vehicle(1.5, true, true);
		assertEquals("Opened Gap", result);
	}
	@Test
	public void OpenedGap_Defect() {
		result = obj.vehicle(1.5, false, false);
		assertEquals("Opened Gap", result);
	}
	
	// No Vehicle detected and no gap
	@Test
	public void HappyJourney() {
		result = obj.vehicle(2.5, false, false);
		assertEquals("Happy Journey!", result);
	}
	@Test
	public void HappyJourney_Defect() {
		result = obj.vehicle(2.5, true, true);
		assertEquals("Happy Journey!", result);
	}
	

}
