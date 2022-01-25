package TruckPl;

public class UnitTesting {
	private String result;
	public String pedestrian(boolean check1, boolean check2) {
		
		if(check1){							// DETECTS PEDESTRIAN?
			result = "Slowing Down...";
			if(check2){						// STILL THERE?
		    	result = "Braking...";		
		    }
		}
		else {
			result = "Happy Journey!";
		}		
		return result;
	}
	
	public String vehicle(double distance, boolean lights, boolean opened) {
		
		if(distance < 2){					// VEHICLE DETECTED?
			result = "Vehicle Detected";
		    if(lights){						// VEHICLE WITH LIGHTS DETECTED?
		    	if(!opened){					// N0 OPENED GAP?
		    	  result = "Opening Gap...";
		    	  opened = true;
		    	}
		    	else{						// OPENED GAP
		    		result = "Opened Gap";
		    	}
		    }
		}
		else if(!opened){					// NO VEHICLE DETECTED AND NO OPENED GAP
			result = "Happy Journey!";
		}

		return result;
		
	}
	
	public String closeGap(boolean lights, boolean opened) {
		if(!lights && opened){ 				// NO LIGTHS DETECTED AND OPENED GAP
		      result = "Closing Gap...";
		}else {
			result = "";
		}
		
		return result;
		
	}
}
