package com.tl.josepfu;

public class JosepfulCircleDemo {
	
	private int length;
	private Soldier first;
	
	//��linkedList��Ƶ��c�B�z���αƶ������^�O���ƦC
	//�غc���׬�length��linked list
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
		//��Ȯɫ��V�Ĥ@�Ӫ��e�@��,�p�G�`�@��10�N�O��10
		for(int i = 0; i <length-1;i++) {	
			temp = temp.getNext();
		}
		while(true) {
			if(temp == curr) {
				System.out.println("�̫�@�Ӭ�"+temp.getNum());
				break;
			}
			//����w����e�@�өM�n����������
			for(int j = 0; j<step-1;j++) {
				temp=temp.getNext();
				curr=curr.getNext();
			}
			//�L�X�n������,��curr����U�@��
			System.out.println("�{�b�n�������O"+curr.getNum());
			count++;
			resultArray[curr.getNum()-1]=count;
			curr= curr.getNext();
			temp.setNext(curr);
			
			
			
		}
		
		return resultArray;
		
	}
	
	
}
