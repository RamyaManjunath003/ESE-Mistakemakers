## Hardware implementation in TinkerCad

https://www.tinkercad.com/things/iYuWG3QEAQT


Simulation steps:

1.	Vehicle detected without lights (before opening a gap)	
	- Sensor: dist<2
		- Vehicle detected

2.	Vehicle detected with lights (before opening a gap)
	- Sensor: dist<2, Enter in Serial monitor: 0
		- Opening Gap...
		- Opened Gap
	
3.	Vehicle detected turn off lights after opening a gap
	- Sensor: dist<2, Serial Monitor: 2
		- Closing Gap...
		- Vehicle detected

4.	Repeat step 2.

5.	Vehicle detected dissapears after opening a gap
	- Sensor: dist>2, Serial Monitor: 2
		- Closing Gap...
		- Happy Journey!
