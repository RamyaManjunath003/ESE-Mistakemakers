#include <LiquidCrystal.h>
#define ECHO 10
#define TRIGGER 9

float time = 0,distance=0;
char camera = 0;
LiquidCrystal lcd(12,11,5,4,3,2);
bool pedestrian = false;

void setup() {
  pinMode(TRIGGER, OUTPUT);
  pinMode(ECHO, INPUT);
  Serial.begin(9600);
  lcd.begin(16, 2);

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
  
  
 
  delay(1000);
  
}
