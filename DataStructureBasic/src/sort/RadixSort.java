package sort;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String args[]) {
		int[] array = {3,8,53,63,25,45,109,9,7};
		
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}


//演算法分析
	//列出編號0~9的桶子
	//把arr的數字依 "個位數" 放到對應的桶子裡
	//從桶子中依序拿出來放回arr
	//再把arr中的數字依 "10位數" 放到對應的桶子
	//從桶子中依序拿出來放回arr
	//重複直到結束
	
	public static void radixSort(int[] arr) {
		//對應的bucket
		int[][] bucket = new int[10][arr.length];
		//紀錄bucket的各個位數的index
		int[] record = new int[10];

		//找到最大的數
		int max = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if (arr[i]>max) {
				max = arr[i];
			}			
		}
		//最大的數的位數
		int digit = (max+"").length();
		int currentDigit = 1;
		for(int k = 0 ; k<digit ; k++ ) {
			
			//第一輪 依個位數字放入
			for(int i = 0;i<arr.length;i++) {
				bucket[arr[i]/currentDigit%10][record[arr[i]/currentDigit%10]]=arr[i];
				record[arr[i]/currentDigit%10]++;
				;
			}
			//System.out.println("index arr= " + Arrays.toString(record));
			//按照順序拿出來放
			for(int j = 0,count = 0;j<10;j++) {
				for(int i = 0;i <record[j];i++) {
					arr[count] = bucket[j][i];
					count++;
				}
			}
			//初始化紀錄
		    for(int i = 0; i <record.length;i++) {
		    	record[i]=0;
		    }
						
			currentDigit *=10; 
		}
		
		
		
		
	}
	
	
}
