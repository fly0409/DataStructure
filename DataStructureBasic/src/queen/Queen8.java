package queen;

public class Queen8 {

	int max = 8;
	static int count =0;
	int[] ansArray =new int[max];
	public static void main(String[] args) {
		Queen8 q8 = new Queen8();
		q8.check(0);
		System.out.println("進行"+count+"次");
	}
	//放置第n個queen
	private void check(int n) {
		if (n==max) {
			print();
			return;
		}
		//依次放入queen看是否有衝突
		for(int i =0;i<max;i++) {
			//把第n個皇后放在第i個位置
			ansArray[n]=i;
			if(judge(n)) {
				check(n+1);
			}			
		}		
	}
	//放置第n個皇后的確認
	private boolean judge(int num) {
		//從第0個開始依序確認到第n個
		count++;
		for(int i = 0 ; i< num;i++) {
			//同列 ||斜邊
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
