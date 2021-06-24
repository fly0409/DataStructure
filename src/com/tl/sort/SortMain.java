package com.tl.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
@SuppressWarnings("unused")
public class SortMain {

	public static void main(String[] args) {
		int[] array = {1,9,8,7,4,6,2,3,5};
		
		int[]array1 = new int[800000];
		for(int i=0;i<800000;i++) {
			array1[i]=(int) (800000*Math.random());
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		System.out.println(sdf.format(date));
		
		
		//BubbleSort bubble = new BubbleSort();
		//int[] arrayAfter = bubble.bubbleSort(array1);
		//System.out.println(Arrays.toString(arrayAfter));
		
		//SelectSort selectSort = new SelectSort();
		//int[] arraySorted = selectSort.selectSort(array1);
		//System.out.println(Arrays.toString(arraySorted));
		
		InsertionSort insertion = new InsertionSort();
		int[] arraySorted = insertion.insertionSort(array1);

		//ShellSort shell = new ShellSort();
		//shell.shellSort(array1);
		
		
		Date date2 = new Date();
		System.out.println(sdf.format(date2));

	}

}
