package com.javaoop.calculator1;

public class Calculator {
	private double num1;
	private double num2;
	private double result;
	
	public Calculator() {
		
	}
	
	public void setOperandOne(double num1) {
		this.num1 = num1;
	}
	
	public void setOperandTwo(double num2) {
		this.num2 = num2;
	}
	
	public void performOperation(char op) {
		switch (op) {
        case '+':
            this.result = this.num1 + this.num2;
            break;
        case '-':
            this.result = this.num1 - this.num2;
            break;
		}
	}
	public double getResults() {
		return this.result;
	}
}