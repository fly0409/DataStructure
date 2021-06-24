package com.tl.sort;

import java.util.Arrays;

public class QuickSort {

	//�N�}�C���䤤�@�ӷ�@������
	//��L�j����k��
	//��o�p������
	//�@�����ƤW�z�ʧ@
	
	public void quickSort(int[] arr,int left,int right) {
		
		if(left >= right) {
			return;
		}		
		
		int l = left;
		int r = right;
		int temp = 0;
		//�Ĥ@���A��L�q���G��A���pivotNum�٤j���AR�q�k�G��A���pivotNum�٤p��
		//�p�G���۳������N�洫
		//pivotNum�]���Ĥ@�ӼƦr
		int pivotNum = arr[l];
		while(l != r) {
			//why�@�w�n��������?  =>���]�i�H���k��A���L��X�ӤFindex�n�1
			//������A����pivot�p��
			while(arr[r]>pivotNum && l<r) {
				r--;
			}
			//���k��A����pivot�j��
			while (arr[l]<=pivotNum && l<r) {
				l++;
			}
			
			//�����ӫ��w�S�����쪺���p�U
			if(l<r) {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				r=right;
				l=left;
			}	
			//System.out.println("l:r "+l+":"+r);
			//System.out.println(Arrays.toString(arr));
		}
		temp = arr[l];
		arr[l] = pivotNum;
		arr[left] = temp;
		
		quickSort(arr,left,l-1);
		quickSort(arr,l+1,right);		
		
	}
	
public void quickSort2(int[] arr,int left,int right) {
		
		if(left >= right) {
			return;
		}		
		
		int l = left;
		int r = right;
		int temp = 0;
		//�Ĥ@���A��L�q���G��A���pivotNum�٤j���AR�q�k�G��A���pivotNum�٤p��
		//�p�G���۳������N�洫
		//pivotNum�]���Ĥ@�ӼƦr
		int pivotNum = arr[l];
		while(l != r) {
			//why�@�w�n��������?  =>���]�i�H���k��A���L��X�ӤFindex�n�1
			//������A����pivot�p��
			//���k��A����pivot�j��
			while (arr[l]<=pivotNum && l<r) {
				l++;
			}
			
			while(arr[r]>pivotNum && l<r) {
				r--;
			}
			
			
			//�����ӫ��w�S�����쪺���p�U
			if(l<r) {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				r=right;
				l=left;
			}	
			//System.out.println("l:r "+l+":"+r);
			//System.out.println(Arrays.toString(arr));
		}
		temp = arr[l-1];
		arr[l-1] = pivotNum;
		arr[left] = temp;
		
		quickSort(arr,left,l-2);
		quickSort(arr,l,right);		
		
	}
	
	
	
	public void quickSort2g(int[] arr,int left,int right) {
		int l = left;
		int r = right;
		int temp = 0;
		int pivotNum = arr[(left+right)/2];
		
		while(l<r) {
			while(arr[l]<=pivotNum) {
				l++;			
			}

			while(arr[r]>=pivotNum) {
				r--;				
			}
			
			if(l>=r) {
				break;
			}
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			
			if(arr[l]==pivotNum) {
				r--;
			}
			if(arr[r]==pivotNum) {
				l++;
			}
			
		}
		
		if (l==r) {
			l++;
			r--;
		}
		
		if(left<r) {
			quickSort2(arr,left,r);
		}
		if(right>l) {
			quickSort2(arr,l,right);
		}
		
	}
	
}
