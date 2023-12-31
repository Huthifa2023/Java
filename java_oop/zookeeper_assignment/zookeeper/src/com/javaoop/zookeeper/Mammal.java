package com.javaoop.zookeeper;

public class Mammal {
	private int energyLevel = 100;
	
	public int displayEnergy() {
		return this.energyLevel;
	}
	
	public int setEnergy(int amount) {
		return this.energyLevel += amount;
	}
	
}
