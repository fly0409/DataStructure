package sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SelectSort {	
	
	public int[] selectSort(int[] array) {

		for(int j = 0;j<array.length-1;j++) {
			//每一輪把最小的丟到最前面
			//先記錄每輪中最小的那個
			int min = array[j];
			int minIndex = j;
			//若是有其他最小值，則紀錄index
			for(int i = j+1 ; i <array.length;i++) {
				if(min>array[i]) {
					min = array[i];
					minIndex = i;
				}
			}
			//取的最小值後，交換位置
			array[minIndex]=array[j];
			array[j]=min;			
			//System.out.println(Arrays.toString(array));
		}
		
		return array;
		
	}
	
	
}
