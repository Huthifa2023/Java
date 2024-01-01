package com.javaoop.abstractart;

public abstract class Art {
	private String title;
	private String author;
	private String desctiption;
	
	public abstract String viewArt();
	
	//constructor
	public Art() {
	}
	public Art(String title, String author, String desctiption) {
		this.title = title;
		this.author = author;
		this.desctiption = desctiption;
	}
	
	//getters
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getDescription() {
		return this.desctiption;
	}
	
	//setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDescription(String desctiption) {
		this.desctiption = desctiption;
	}
}
