package com.tl.stack;

public class Calculator {
	//��J�@��⦡�r��,�D�X����
	private StackArrayCal numStack= new StackArrayCal(10);
	private StackArrayCal operStack= new StackArrayCal(10);
	int num1 = 0;
	int num2 = 0;
	int oper = 0;
	String formula = "2+4*5-2";
	char ch =' ';
	
	public Calculator() {
	}
	public Calculator(String formula) {
		this.formula=formula;
	}
	
	
	
	
}
