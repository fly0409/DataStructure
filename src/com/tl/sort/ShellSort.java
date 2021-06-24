package com.tl.sort;

import java.util.Arrays;

public class ShellSort {
	
	public void shellSort(int[] array) {		
		//先分成length/2組
		//每組排序
		int temp;
		for(int size = array.length/2;size>0;size/=2) {
			
			//第一輪=>假設有6個數字，分3組
			//每一組排序
			
			//從size開始走訪
			for(int i = size;i<array.length;i++) {
				//j為i-size，若是size為2，length為9，j最大是7(因為要跟後面那個比)	
				//j往後看，如果後面比他小，就跟他換，然後j往後走回0
				for(int j = i-size;j>=0;j-=size) {
					//如果當前的J比後面大就交換
					if(array[j]>array[j+size]) {
						temp = array[j+size];
						array[j+size] = array[j];
						array[j] = temp;
					}
				}
				
			}
			
			//System.out.println(Arrays.toString(array));
			
		}
		
	}
}
