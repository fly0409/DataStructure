package com.tl.sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SelectSort {	
	
	public int[] selectSort(int[] array) {

		for(int j = 0;j<array.length-1;j++) {
			//–近р程メ程玡
			//癘魁–近い程ê
			int min = array[j];
			int minIndex = j;
			//璝琌Τㄤ程玥魁index
			for(int i = j+1 ; i <array.length;i++) {
				if(min>array[i]) {
					min = array[i];
					minIndex = i;
				}
			}	
			//程ユ传竚
			array[minIndex]=array[j];
			array[j]=min;			
			//System.out.println(Arrays.toString(array));
		}
		
		return array;
		
	}
	
	
}
