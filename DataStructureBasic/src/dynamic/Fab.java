package dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fab {

	public static void main(String[] args) {
		
		FabDemo fab = new FabDemo();
		Map<String, Long> memo = new HashMap<String,Long>();
		long num1 = fab.fabnum(7,memo);
		long num2 = fab.fabnum(80,memo);
		System.out.println(num1);
		System.out.println(num2);
	}
}
//利用memoized的方式儲存結果，將時間複雜度從O(2^n)變為O(n)，回想一下樹的結構
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