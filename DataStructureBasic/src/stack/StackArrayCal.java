package stack;

public class StackArrayCal {

	private int[] stackArray;
	private int length;
	private int top=-1;

	public StackArrayCal(int length) {
		this.length=length;
		stackArray = new int[length];
		}
	
	public boolean isFull() {
		return top>=length-1;		
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public void push(int num) {
		if (!isFull()) {
			top++;
			stackArray[top]=num;
		}else {
			System.out.println("stack is Full");
		}		
	}
	
	public int pop() {
		
		if(!isEmpty()) {
			return stackArray[top--];
		}else {
			throw new RuntimeException("stack is Empty");
		}
		
	}
	
	public void viewStack() {	
		if(!isEmpty()) {
			System.out.println("this stack is:");
			for(int i = top;i>=0;i--) {				
				System.out.print(stackArray[i]+" ");
			}
			System.out.println("");
		}else {
			throw new RuntimeException("stack is Empty");
		}		
	}
	
	public int peek() {
		if(!isEmpty()) {
			return stackArray[top];
		}else {
			throw new RuntimeException("stack is Empty");
		}	
	}
	
	
	//for Calculator
	//judge whether oper
	public boolean isOper(char ch) {
		return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')';
	}
	
	public int calculate(int num1,int num2,int ch) {
		switch(ch) {
		case '+':
			return num1+num2;
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/num2;
		default:
			break;
		}
		System.out.println("somthing wrong");
		return 0;		
	}
	
	public int judgeOrder(int opr) {
		if (opr=='+'||opr=='-') {
			return 0;
		}else if(opr=='*'||opr=='/') {
			return 1;
		}else if(opr=='(') {
			return 2;
		}else if(opr==')') {	
			return 2;
		}else {
			return -2;
		}
	}
	
	public boolean isRightBracket(int opr) {
		return opr==')';
	}
	
	
	
	
	
}
