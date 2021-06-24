package com.tl.queen;

public class Queen8 {

	int max = 8;
	static int count =0;
	int[] ansArray =new int[max];
	public static void main(String[] args) {
		Queen8 q8 = new Queen8();
		q8.check(0);
		System.out.println("�i��F"+count+"��");
	}
	//��m��n��queen
	private void check(int n) {
		if (n==max) {
			print();
			return;
		}
		//�̦���Jqueen�ݬO�_���Ĭ�
		for(int i =0;i<max;i++) {
			//���n�ӬӦZ��b��i�Ӧ�m
			ansArray[n]=i;
			if(judge(n)) {
				check(n+1);
			}			
		}		
	}	
	//��m��n�ӬӦZ���T�{
	private boolean judge(int num) {
		//�q��0�Ӷ}�l�̧ǽT�{���n��
		count++;
		for(int i = 0 ; i< num;i++) {
			//�P�C ||����
			if(ansArray[i] == ansArray[num]||Math.abs(num-i)==Math.abs(ansArray[num]-ansArray[i])) {
				return false;
			}
		}		
		return true;
	}	
	
	private void print() {
		for(int i = 0;i<max;i++) {
			System.out.print(ansArray[i]+" ");
		}
		System.out.println();
	}

}
