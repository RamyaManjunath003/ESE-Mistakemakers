package TruckPl;

import static org.junit.Assert.*;

import org.junit.Test;

public class GapTest {

	UnitTesting obj = new UnitTesting();
	String result;
	
	@Test
	// No lights detected after opening a gap
	public void ClosingGap() {
		result = obj.closeGap(false, true);
		assertEquals("Closing Gap...", result);
	}
	
	@Test
	public void ClosingGap_Defect() {
		result = obj.closeGap(true, true);
		assertEquals("Closing Gap...", result);
	}
}
