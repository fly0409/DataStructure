package com.tl.sort;
@SuppressWarnings("unused")
public class BubbleSort {

	public BubbleSort() {
		
	}

	public int[] bubbleSort(int[] array) {
		int temp;
		
		
		//�C�@����̤j���Ʀr���̫�@��
		for(int i = 0;i<array.length;i++) {
			for(int j = 0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}			
		}
		
		
		
		
		return array;
	}
	
	public void print(int[] array) {
		for(int i:array) {
		 System.out.print(i+" ");
		}
		System.out.println();
	}
	
}



