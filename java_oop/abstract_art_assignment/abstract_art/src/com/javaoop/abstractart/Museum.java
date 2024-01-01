package com.javaoop.abstractart;
import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		Painting paint1 = new Painting("paint111", "samah nasri", "dammasdasd", "watermark");
		Painting paint2 = new Painting("paint222", "fatooh hamed", "wwowoowow", "blackwhite");
		Painting paint3 = new Painting("paint333", "qadri qzme", "nowowmo wowo", "humble");
		
		Sculpture scul1 = new Sculpture("scul111", "ahmad mazyn", "awsomeone", "iron");
		Sculpture scul2 = new Sculpture("scu222", "jamal haj", "wowowow", "rocks");
		
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.add(paint1);
		museum.add(paint2);
		museum.add(paint3);
		
		museum.add(scul1);
		museum.add(scul2);
		
		
		Collections.shuffle(museum);
		for(Art i : museum) {
			System.out.println(i.getTitle()+" " + i.getAuthor() +" " + i.getDescription()+ "\n");
		}
	}

}
