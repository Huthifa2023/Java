package com.javaoop.zookeeper;

public class BatMan extends Mammal{
	
	public BatMan() {
		super.setEnergy(200);
	}
	
	public String fly() {
		super.setEnergy(-50);
		return ("the bat is airborne " + "energy level: " +super.displayEnergy());
	}
	
	public String eatHumans() {
		super.setEnergy(25);
		return ("the bat is eating human "+ "energy level: " +super.displayEnergy());
	}
	
	public String attackTown() {
		super.setEnergy(-100);
		return ("bat atatcking the town "+ "energy level: " +super.displayEnergy());
	}
	
	
}
