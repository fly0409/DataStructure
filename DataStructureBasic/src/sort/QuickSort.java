package sort;

import java.util.Arrays;

public class QuickSort {

	//將陣列中其中一個當作中間值(此案例為最右邊的)
	//比他大的放右邊
	//比她小的放左邊
	//一直重複上述動作
	
	public void quickSort(int[] arr,int left,int right) {
		
		if(left >= right) {
			return;
		}		
		
		int l = left;
		int r = right;
		int temp = 0;
		//第一輪，把L從左逼近，找比pivotNum還大的，R從右逼近，找比pivotNum還小的
		//如果互相都有找到就交換
		//pivotNum設為第一個數字
		int pivotNum = arr[l];
		while(l != r) {
			//why一定要先往左找?  =>其實也可以往右找，不過找出來了index要減掉1
			//往左找，找到比pivot小的
			while(arr[r]>pivotNum && l<r) {
				r--;
			}
			//往右找，找到比pivot大的
			while (arr[l]<=pivotNum && l<r) {
				l++;
			}

			//有找到而指針沒有撞到的情況下
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
	//第一輪，把L從左逼近，找比pivotNum還大的，R從右逼近，找比pivotNum還小的
	//如果互相都有找到就交換
	//pivotNum設為第一個數字
		int pivotNum = arr[l];
		while(l != r) {
			//why一定要先往左找?  =>其實也可以往右找，不過找出來了index要減掉1
			//往左找，找到比pivot小的
			//往右找，找到比pivot大的
			while (arr[l]<=pivotNum && l<r) {
				l++;
			}
			
			while(arr[r]>pivotNum && l<r) {
				r--;
			}

			//有找到而指針沒有撞到的情況下
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
