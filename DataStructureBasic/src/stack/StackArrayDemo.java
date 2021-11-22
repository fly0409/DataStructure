package stack;

import java.util.Scanner;

public class StackArrayDemo {

	public static void main(String[] args) {
		boolean goloop=true;
		StackArray myStack = new StackArray(5);
		
		while(goloop) {
			char s;
			System.out.println("選擇以下動作");
			System.out.println("a(add):新增數字");
			System.out.println("g(get):取得數字");
			System.out.println("h(head):觀看首位");
			System.out.println("s(show):觀看陣列");
			System.out.println("e(exit):離開");
			Scanner scanner = new Scanner(System.in);
			s=scanner.next().charAt(0);
			switch(s) {
			case 'a':
				System.out.println("輸入數字:");
				Scanner scanner1 = new Scanner(System.in);
				int addNum = scanner1.nextInt();
				myStack.push(addNum);
				//scanner1.close();
				break;
			case 'g':
				int getNum = myStack.pop();
				System.out.println("取出數字:"+getNum);
				break;
			case 'h':
				int headNum = myStack.peek();
				System.out.println("首個數字:"+headNum);
				break;
			case 's':
				myStack.viewStack();
				break;
			case 'e':
				goloop=false;
				scanner.close();
				break;
			default:
				break;
			}
			
			
		}
		System.out.println("確認離開");
		

	}

}
