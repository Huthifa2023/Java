package com.javaoop.abstractart;

public class Sculpture extends Art {
	
	private String material;
	
	//constructor
	public Sculpture() {	
	}
	public Sculpture(String title, String author, String desctiption, String material) {
		super(title, author, desctiption);
		this.material = material;
	}
	
	public String viewArt() {
		return "this is sculpture";
	}
	
	//getters
	public String getMaterial() {
		return this.material;
	}
	
	//setters
	public void setMaterial(String material) {
		this.material = material;
	}
}
