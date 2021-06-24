package com.tl.stack;

import java.util.Scanner;

public class StackArrayDemo {

	public static void main(String[] args) {
		boolean goloop=true;
		StackArray myStack = new StackArray(5);
		
		while(goloop) {
			char s;
			System.out.println("��ܥH�U�ʧ@");
			System.out.println("a(add):�s�W�Ʀr");
			System.out.println("g(get):���o�Ʀr");
			System.out.println("h(head):�[�ݭ���");
			System.out.println("s(show):�[�ݰ}�C");
			System.out.println("e(exit):���}");
			Scanner scanner = new Scanner(System.in);
			s=scanner.next().charAt(0);
			switch(s) {
			case 'a':
				System.out.println("��J�Ʀr");
				Scanner scanner1 = new Scanner(System.in);
				int addNum = scanner1.nextInt();
				myStack.push(addNum);
				//scanner1.close();
				break;
			case 'g':
				int getNum = myStack.pop();
				System.out.println("���X�Ʀr�G"+getNum);
				break;
			case 'h':
				int headNum = myStack.peek();
				System.out.println("���ӼƦr�G"+headNum);
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
		System.out.println("�T�{���}");
		

	}

}
