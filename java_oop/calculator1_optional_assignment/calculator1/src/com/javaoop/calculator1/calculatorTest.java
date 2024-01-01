package com.javaoop.calculator1;

public class calculatorTest {

	public static void main(String[] args) {
		Calculator hhh = new Calculator();
		
		hhh.setOperandOne(10.5);
		hhh.setOperandTwo(5.2);
		hhh.performOperation('+');
		double sum = hhh.getResults();
		System.out.println(sum);
		
		
		
		hhh.setOperandOne(10.5);
		hhh.setOperandTwo(5.2);
		hhh.performOperation('-');
		double sub = hhh.getResults();
		System.out.println(sub);
	}

}
