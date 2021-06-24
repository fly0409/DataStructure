package com.tl.dsprac.Queue;

import java.util.Scanner;

public class CircleArray {

	public static void main(String[] args) {
		boolean goloop=true;
		CircleQueue quene = new CircleQueue(4);
		
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
				//scanner1.close();
				break;
			case 'g':
				try{
					int getNum = quene.getNum();
					System.out.println("���X�Ʀr�G"+getNum);
					break;					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			case 'h':
				try{
				int headNum = quene.getHead();
				System.out.println("���ӼƦr�G"+headNum);
				break;
				}catch(Exception e) {
					e.printStackTrace();
				}
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

class CircleQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arrayQueue;
	
	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;//�{�b��̫�@�Ӧ�m�w�d�A��K����
		arrayQueue = new int[maxSize];
		front = 0;//���V�Y��,���V�Y�@�ӼƦr����m
		rear = 0;//���V���ڪ��Ʀr+1(ex�p�G�}�C�Ʀr��m�b0,1,2 ��2,��rear�N�O2+1)
	}
	
	public boolean isFull() {
		if ((rear+maxSize-front)%maxSize == maxSize-1) {
			return true;
		}
		return false;
		//return rear == maxSize-1;
	}
	public boolean isEmpty() {
		return (front == rear);
	}
	
	public void addNum(int num) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		}else {
			arrayQueue[rear] = num;
			rear=(rear+1)%maxSize;
			return;
		}		
	
	}
	
	public int getNum() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}			
		int getnumber = arrayQueue[front];
		front = (front+1)%maxSize;
		return getnumber;
	}
	
	public void showArray() {
		if(isEmpty()) {
			System.out.println("array is Empty");
			return;
		}
		for(int i = front ;i < front+getCurrentSize();i++) {
			System.out.printf("array[%d] is %d\n",i%maxSize,arrayQueue[i%maxSize]);
		}
	}
	
	public int getCurrentSize() {
		return (rear-front+maxSize)%maxSize;
	}
	public int getHead() {
		if(isEmpty()) {
			throw new RuntimeException("array is Empty");
		}
		return arrayQueue[front];
	}
	
	
}
