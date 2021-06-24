package com.tl.dsprac.Queue;

import java.util.Scanner;
/*��@Quene
 * �Q��Array �إߨ�ӫ��� rear �Mfront
 */


public class ArrayQueue {

	public static void main(String[] args) {
		boolean goloop=true;
		Queue quene = new Queue(3);
		
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
				quene.addNum(addNum);
				break;
			case 'g':
				int getNum = quene.getNum();
				System.out.println("���X�Ʀr�G"+getNum);
				break;
			case 'h':
				int headNum = quene.getHead();
				System.out.println("���ӼƦr�G"+headNum);
				break;
			case 's':
				quene.showArray();
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
class Queue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arrayQueue;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arrayQueue = new int[maxSize];
		front = -1;//���V�Y��,���V�e�@�Ӧ�m
		rear = -1;//���V����,�N�Oarray�̫�@��
	}
	
	public boolean isFull() {
		if (rear == maxSize-1) {
			return true;
		}
		return false;
		//return rear == maxSize-1;
	}
	
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}
	
	public void addNum(int num) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}else {
			rear++;
			arrayQueue[rear] = num;
			return;
		}		
	
	}
	
	public int getNum() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		front++;
		int getnumber = arrayQueue[front];
		return getnumber;
	}
	
	public void showArray() {
		if(isEmpty()) {
			System.out.println("array is Empty");
			return;
		}
		for(int i = front+1 ;i <maxSize;i++) {
			System.out.printf("array[%d] is %d\n",i,arrayQueue[i]);
		}
	}
	public int getHead() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		return arrayQueue[front+1];
	}
	
	
	
	
}

