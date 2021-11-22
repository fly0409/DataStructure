package sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class InsertionSort {
	
	public int[] insertionSort(int[] array) {
		//把第一個當做已經排序的
		//然後把第二個丟進來進行排序
		//
		
		for(int j = 1;j<array.length;j++) {
			int insertNum = array[j];
			int insertIndex = j-1;
			//第一輪把i以前當作以排序，加入新的去排

			//第一種寫法，走訪整個已經排序的，如果array[i]比插入的數字大，就把array[i]改成要插入的數字，array[i]的值拿去做後面的比較
			/*
			for(int i = 0;i<j;i++) {
				if(array[i]>insertNum) {
					temp = array[i];
					array[i]=insertNum;
					array[j]=temp;
					insertNum=temp;
				}
				}
			 */
			//第二種寫法，找到要插入的index
			//如果要插入的數小於要插入的數的前一個
			//便把前一個放到要插入的數的index(ex:{21,'19',20}=>{21,21,20},19放到insertNum裡面)
			while(insertIndex>=0 && insertNum<array[insertIndex]) {
				array[insertIndex+1]=array[insertIndex];
				insertIndex--;
			}
			array[insertIndex+1]=insertNum;
				
			
			//System.out.println(Arrays.toString(array));
		}
	
		
		
		
		
		return array;
	}
		
	public int[] insertionSort2(int[] array) {
		//把第一個當做已經排序的
		//然後把第二個丟進來進行排序
		//
		int temp=0;
		for(int j = 1;j<array.length;j++) {
			int insertNum = array[j];

			//第一輪把i以前當作以排序，加入新的去排

			//第一種寫法，走訪整個已經排序的，如果array[i]比插入的數字大，就把array[i]改成要插入的數字，array[i]的值拿去做後面的比較
			
			for(int i = 0;i<j;i++) {			
				if(array[i]>insertNum) {
					temp = array[i];
					array[i]=insertNum;
					array[j]=temp;
					insertNum=temp;
				}					
			}
			//System.out.println(Arrays.toString(array));
		}
		return array;
	}
}
