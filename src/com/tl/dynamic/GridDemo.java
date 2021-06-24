package com.tl.dynamic;

import java.util.HashMap;
import java.util.Map;

//���]���@�Ӱ}�C,�q0,0����}�C�k�U�������|�ƶq

public class GridDemo {

	public static void main(String[] args) {
		Grid grid = new Grid();
		System.out.println(grid.calPath(5,5));
		System.out.println(grid.checkPath(30, 30));
		System.out.println(grid.checkPath(50, 50));
	}

}

class Grid{
	private Map<String,Long> memo;
	
	public Grid() {
		memo = new HashMap<String,Long>();
	}
	
	
	
	public long checkPath(int i,int j) {
		return calPath2(i,j,memo);
	}
	
	
	//�B�@�޿�
	//�p�G���@��O0�A�h�L�k�e�����I
	//�Y���@�䬰1 �N��ܥu���@�����i�H����I
	public int calPath(int i,int j) {
		if(i==0||j==0) {
			return 0;
		}else if(i==1||j==1) {
			return 1;
		}else {
			return calPath(i-1,j)+calPath(i,j-1);
		}	
	}
	//with memo
	private long calPath2(int i,int j,Map<String, Long> memo) {
		if(memo.containsKey(i+","+j)) {
			return (long) memo.get(i+","+j);
		}
		if(i==0||j==0) {
			return 0;
		}else if(i==1||j==1) {
			return 1;
		}else {
			long sum = calPath2(i-1,j,memo)+calPath2(i,j-1,memo);
			memo.put(i+","+j, sum);
			return sum;
		}	
	}
	
}