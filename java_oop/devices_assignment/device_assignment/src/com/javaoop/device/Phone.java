package com.javaoop.device;

public class Phone extends Device {
	
	
	public String makeCall() {
		super.setBattery(-5);
		return ("phone making a call" + "remaining battery:"+ super.getBattery());
	}
	
	public String playGame() {
		if(super.getBattery() <= 25) {
			return ("sorry cannot play the game please charge");
		}
		super.setBattery(-20);
		return ("playing a game"+ "remaining battery:"+ super.getBattery());
	}
	
	public String charge() {
		super.setBattery(50);
		return ("charging..."+ "remaining battery:"+ super.getBattery());
	}
}
