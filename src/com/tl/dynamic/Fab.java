package com.tl.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FabDemo fab = new FabDemo();
		Map<String, Long> memo = new HashMap<String,Long>();
		long num1 = fab.fabnum(7,memo);
		long num2 = fab.fabnum(80,memo);
		System.out.println(num1);
		System.out.println(num2);
	}
}
//�Q��memoized���覡�x�s���G�A�N�ɶ������ױqO(2^n)�ܬ�O(n)�A�^�Q�@�U�𪺵��c
class FabDemo {	
	public long fabnum(long i,Map<String, Long> memo) {
		
		if(i==1||i==2) {
			return 1;
		}else if(memo.containsKey(i+"")) {
			return (long) memo.get(i+"");
		}else {
			long sum = fabnum(i-1,memo)+fabnum(i-2,memo);
			memo.put(i+"", sum);
			return sum;
		}
	}
}