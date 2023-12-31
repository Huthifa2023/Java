package com.javaoop.zookeeper;

public class Gorilla extends Mammal{
	
	public String throwSomething() {
		super.setEnergy(-5);
		return ("gorilla has thrown something "+"enrgy level: "+super.displayEnergy());
	}
	
	public String eatBananas() {
		super.setEnergy(10);
		return ("gorilla eats Banana "+"enrgy level: "+super.displayEnergy());
	}
	
	public String climp() {
		super.setEnergy(-10);
		return ("gorilla climped something "+"enrgy level: "+super.displayEnergy());
	}
}
