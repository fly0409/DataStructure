package stack;

public class StackArray {

	private int[] stackArray;
	private int length;
	private int top=-1;

	public StackArray(int length) {
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
}
