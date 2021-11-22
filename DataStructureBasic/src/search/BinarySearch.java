package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = {1,2,4,7,8,66,78,78,78,78,99};
		int index = binarySeach(array,0,array.length-1,78);			
		System.out.println(index);
		
		
		
		List<Integer> resList = binarySeach2(array,0,array.length-1,88);			
		System.out.println(resList);
	}
	
	public static int binarySeach(int[] arr,int left,int right,int value) {
		
		int mid = (left+right)/2;		
		int midValue = arr[mid];
		if(left>right) {
			return -1;
		}
		
		if (value<midValue) {
			return binarySeach(arr,left,mid-1,value);
						
		}else if (value>midValue) {
			return binarySeach(arr,mid+1,right,value);
		}else {
			return mid;		
		}				
		
	}
	public static List<Integer> binarySeach2(int[] arr,int left,int right,int value) {
		
		int mid = (left+right)/2;		
		int midValue = arr[mid];
		if(left>right) {
			return new ArrayList<Integer>();
		}
		
		if (value<midValue) {
			return binarySeach2(arr,left,mid-1,value);
						
		}else if (value>midValue) {
			return binarySeach2(arr,mid+1,right,value);
		}else {
			ArrayList<Integer> resList = new ArrayList<Integer>();
			resList.add(mid);
			//往左找
			int temp = mid-1;
			while(true) {								
				if(temp <0 || arr[temp]!= value) {
					break;
				}
				resList.add(temp);
				temp--;				
			}

			//往右找
			temp = mid+1;
			while(true) {								
				if(temp >arr.length-1 || arr[temp]!= value) {
					break;
				}
				resList.add(temp);
				temp++;				
			}
			
			
			return resList;
		}		
		
		
	}
	

}

