package com.tl.sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SelectSort {	
	
	public int[] selectSort(int[] array) {

		for(int j = 0;j<array.length-1;j++) {
			//�C�@����̤p�����̫e��
			//���O���C�����̤p������
			int min = array[j];
			int minIndex = j;
			//�Y�O����L�̤p�ȡA�h����index
			for(int i = j+1 ; i <array.length;i++) {
				if(min>array[i]) {
					min = array[i];
					minIndex = i;
				}
			}	
			//�����̤p�ȫ�A�洫��m
			array[minIndex]=array[j];
			array[j]=min;			
			//System.out.println(Arrays.toString(array));
		}
		
		return array;
		
	}
	
	
}
