 
#include <LiquidCrystal.h>
#define ECHO 10
#define TRIGGER 9

float time = 0,distance=0;
char camera = 0;
LiquidCrystal lcd(12,11,5,4,3,2);
bool opened = false;
bool pedestrian = false;
bool ligths = false;

void setup() {
  pinMode(TRIGGER, OUTPUT);
  pinMode(ECHO, INPUT);
  Serial.begin(9600);
  lcd.begin(16, 2);

  lcd.print("Truck");
  lcd.setCursor(0,1);
  lcd.print("Platooning");
  delay(1000);
}

void loop() {
  lcd.clear();
  lcd.setCursor(0,0);
  digitalWrite(TRIGGER, HIGH);
  delay(1);
  digitalWrite(TRIGGER, LOW);  
  time = pulseIn(ECHO,HIGH);
  distance = .0001716*time;

  if (Serial.available() > 0) {		// Character available?
    camera = Serial.read();       	// Read character
    switch(camera){
      case '0':
      		ligths = true;
      		break;
      case '1':
      		pedestrian = true;
      		break;
      case '2':
      		ligths = false;
      		break;
      case '3':
      		pedestrian = false;
      		break;
    }
  }
  
  if(pedestrian){	// DETECTS PEDESTRIAN?
    lcd.clear();
    lcd.print("Slowing Down...");
  	delay(2000);				// WAITS 2 SECS
    if (Serial.available() > 0) {		// Character available?
      if(Serial.read()=='3'){       	// Read character
      	pedestrian = false;
      }
  	}
    if(pedestrian){	// STILL THERE?
        lcd.clear();
      	lcd.print("Braking...");	// OPEN GAP
      while (pedestrian){
      	if (Serial.available() > 0) {		// Character available?
          if(Serial.read()=='3'){       	// Read character
      		pedestrian = false;
          }
        }
      }
    }
  }
  
  if(distance < 2){// DETECTS CAR WITH LIGHTS?
    lcd.clear();
    lcd.print("Vehicle Detected");
    if(ligths){// DETECTS CAR WITH LIGHTS?
      lcd.clear();
      if(!opened){		// No opened Gap
      	lcd.print("Opening Gap...");
      	opened = true;
        delay(2000);				// WAITS 2 SECS
      } 
      lcd.clear();
      lcd.print("Opened Gap");
    }
  }
  else if(!opened){		// No Gap
    lcd.clear();
    lcd.print("Happy Journey!");
  }
 
  delay(1000);
  
}
