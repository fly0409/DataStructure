package com.tl.sort;

import java.util.Arrays;

public class ShellSort {
	
	public void shellSort(int[] array) {		
		//������length/2��
		//�C�ձƧ�
		int temp;
		for(int size = array.length/2;size>0;size/=2) {
			
			//�Ĥ@��=>���]��6�ӼƦr�A��3��
			//�C�@�ձƧ�
			
			//�qsize�}�l���X
			for(int i = size;i<array.length;i++) {
				//j��i-size�A�Y�Osize��2�Alength��9�Aj�̤j�O7(�]���n��᭱���Ӥ�)	
				//j����ݡA�p�G�᭱��L�p�A�N��L���A�M��j���ᨫ�^0
				for(int j = i-size;j>=0;j-=size) {
					//�p�G��e��J��᭱�j�N�洫
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
