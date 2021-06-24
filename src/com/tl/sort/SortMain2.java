package com.tl.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SortMain2 {

	public static void main(String[] args) {
		int[] array = {3,8,5,6,2,4,1,9,7};
		
		int[]array1 = new int[800000];
		for(int i=0;i<800000;i++) {
			array1[i]=(int) (800000*Math.random());
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		System.out.println(sdf.format(date));
		
		QuickSort qs = new QuickSort();
		qs.quickSort(array1, 0, array1.length-1);
		//System.out.println(Arrays.toString(array));
		
		Date date2 = new Date();
		System.out.println(sdf.format(date2));

	}

}
