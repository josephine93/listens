package com.senseos.listens;

public class Alarms {
	public Alarm ochtendklok;
	public Alarm middagklok;
	public Alarm avondklok;
	public boolean weekend;
	public Alarms (boolean weekend){
		this.weekend = weekend;
		//Tijden worden ingesteld
		if (weekend) {
			ochtendklok = new Alarm (10, 14);
			middagklok = new Alarm (14, 18);
			avondklok = new Alarm (18, 22);
		} else {
			ochtendklok = new Alarm (8, 12);
			middagklok = new Alarm (12, 17);
			avondklok = new Alarm (17, 21);
		}
	}
}
