package sort;

public class MergeSort {

	//時間複雜度分析
	//1)拆分的過程會把整個arr切成各一份
	//一次切一到總共n-1刀
	//2)合併的過程
	//兩個排序好的arr排成一個大的要執行的次數=>2 大個arr的length次
	//8個小array=>4個=>2個=>1個  以logN對數成長
	//=>2nlogN
	//總時間 O(n-1+2nlogN)=>O(nlogN)


	public void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left+right)/2;
			//向左遞迴
			mergeSort(arr,left,mid,temp);
			//向左遞迴
			mergeSort(arr,mid+1,right,temp);
			//合併
			merge(arr,left,mid,right,temp);
		}

	}
	/*  arr:放入的陣列
	 * 	left:左邊的index
	 *  mid:中間的inde
	 * 	right:右邊的index
	 *  temp:輔助陣列
	 */


	public void merge(int[] arr,int left,int mid,int right,int[]temp) {
		int i = left;//初始化i，從陣列最左邊算起
		int j = mid +1;//初始化j，從陣列中間值+1
		int t = 0; //站存陣列的index
		//1.
		//先把左右兩邊按照順序排好的陣列丟到temp中
		//直到有一邊放完
		while(i<=mid && j <=right) {
			if(arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			}else{
				temp[t++] = arr[j++];
			}
		}

		//2.
		//把剩餘的data都照順序放在temp
		while(i<=mid) {
			temp[t++]=arr[i++];
		}
		while(j<=right) {
			temp[t++]=arr[j++];
		}
		//3.
		//將temp陣列的data放回去
		int tempInit = 0;
		int templeft = left;
		System.out.println("templeft="+templeft+",right = "+right);
		while(templeft <= right) {
			arr[templeft++]= temp[tempInit++];
		}
		
	}
}
