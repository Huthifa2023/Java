package com.javaoop.abstractart;

public class Painting extends Art {
	private String paintType;
	
	//constructor
	public Painting() {
	}
	public Painting(String title, String author, String desctiption, String paintType) {
		super(title, author, desctiption);
		this.paintType = paintType;
	}
	
	public String viewArt() {
		return "this is painting";
	}
	
	//getters
	public String getPaintType() {
		return this.paintType;
	}
	
	//setters
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
}
