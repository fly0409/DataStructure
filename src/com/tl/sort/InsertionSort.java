package com.tl.sort;

import java.util.Arrays;

@SuppressWarnings("unused")
public class InsertionSort {
	
	public int[] insertionSort(int[] array) {
		//��Ĥ@�ӷ��w�g�ƧǪ�
		//�M���ĤG�ӥ�i�Ӷi��Ƨ�
		//
		
		for(int j = 1;j<array.length;j++) {
			int insertNum = array[j];
			int insertIndex = j-1;
			//�Ĥ@����i�H�e��@�H�ƧǡA�[�J�s���h��
			
			//�Ĥ@�ؼg�k�A���X��Ӥw�g�ƧǪ��A�p�Garray[i]�񴡤J���Ʀr�j�A�N��array[i]�令�n���J���Ʀr�Aarray[i]���Ȯ��h���᭱�����
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
			//�ĤG�ؼg�k�A���n���J��index
			//�p�G�n���J���Ƥp��n���J���ƪ��e�@��
			//�K��e�@�ө��n���J���ƪ�index(ex:{21,'19',20}=>{21,21,20},19���insertNum�̭�)
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
		//��Ĥ@�ӷ��w�g�ƧǪ�
		//�M���ĤG�ӥ�i�Ӷi��Ƨ�
		//
		int temp=0;
		for(int j = 1;j<array.length;j++) {
			int insertNum = array[j];
			
			//�Ĥ@����i�H�e��@�H�ƧǡA�[�J�s���h��
			
			//�Ĥ@�ؼg�k�A���X��Ӥw�g�ƧǪ��A�p�Garray[i]�񴡤J���Ʀr�j�A�N��array[i]�令�n���J���Ʀr�Aarray[i]���Ȯ��h���᭱�����
			
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
