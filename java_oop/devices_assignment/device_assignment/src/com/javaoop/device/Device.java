package com.javaoop.device;

public class Device {
	private int battery = 100;
	
	public int getBattery() {
		if(this.battery < 10) {
			System.out.println("battery critical");
		}
		return this.battery;
	}
	
	public void setBattery(int amount) {
		this.battery += amount;
	}
}
