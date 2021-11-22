package stack;

public class Calculator {
	//輸入一串算式字串,求出答案
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
