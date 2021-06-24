package com.tl.josepfu;

public class JosepfulCircleDemo {
	
	private int length;
	private Soldier first;
	
	//用linkedList資料結構處理環形排隊漸漸淘汰的數列
	//建構長度為length的linked list
	public JosepfulCircleDemo(int length) {
		first=new Soldier(-1);
		Soldier temp = first;
		this.length=length;
		for ( int i = 1; i <=length; i++) {
		
			//Soldier soldier = 
			//System.out.println(soldier.getNum());
			temp.setNext(new Soldier(i));
			if(i == length) {			
				temp.getNext().setNext(first.getNext());
				break;
			}
			temp = temp.getNext();
		}	
		
	}
	
	public void showCicle() {
		Soldier temp = first.getNext();
		for(int i = 0; i <length;i++) {			
			System.out.println(temp.getNum());
			temp = temp.getNext();
		}
	}
	
	
	public int[] startCircle(int start,int step) {
		Soldier temp= first.getNext();
		Soldier curr=first.getNext();
		int[] resultArray = new int[length];
		int count = 0;
		//把暫時指向第一個的前一個,如果總共有10就是第10
		for(int i = 0; i <length-1;i++) {	
			temp = temp.getNext();
		}
		while(true) {
			if(temp == curr) {
				System.out.println("最後一個為"+temp.getNum());
				break;
			}
			//把指針指到前一個和要拿掉的那個
			for(int j = 0; j<step-1;j++) {
				temp=temp.getNext();
				curr=curr.getNext();
			}
			//印出要拿掉的,把curr指到下一個
			System.out.println("現在要拿掉的是"+curr.getNum());
			count++;
			resultArray[curr.getNum()-1]=count;
			curr= curr.getNext();
			temp.setNext(curr);
			
			
			
		}
		
		return resultArray;
		
	}
	
	
}
