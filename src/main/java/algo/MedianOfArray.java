package main.java.algo;

/*
 * median of two sorted array
 * */

public class MedianOfArray {

	public MedianOfArray(){}
	
	//median of two sorted array with the same length
	public int medianSameLen(int[] arr1, int[] arr2){
		int len = arr1.length;
		return medianSameLenHelper(arr1, 0, len - 1, arr2, 0, len - 1);
	}
	
	public int getMedian(int[] arr, int l, int r){
		if((r - l + 1) % 2 == 1){
			return arr[l + (r - l)/2];
		}else{
			return (arr[l + (r - l - 1)/2] + arr[l + (r - l)/2])/2;
		}
	}
	
	public int medianSameLenHelper(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2){
		int n = r1 - l1 + 1;
		if( n<= 0)
			return -1;
		if(n == 1){
			return (arr1[l1] + arr2[l2])/2;
		}
		if(n == 2){
			return (Math.min(arr1[r1], arr2[r2]) + Math.max(arr1[l1], arr2[l2]))/2;
		}
		int m1 = getMedian(arr1, l1, r1);
		int m2 = getMedian(arr2, l2, r2);
		if(m1 == m2)
			return m1;
		else if(m1 > m2){
			if(n % 2 == 1)
				return medianSameLenHelper(arr1, l1, l1 + n/2, arr2, l2 + n/2, r2 );
			else
				return medianSameLenHelper(arr1, l1, l1 + (n - 1)/2 + 1, arr2, l2 + (n - 1)/2 , r2);
		}else{
			if(n % 2 == 1)
				return medianSameLenHelper(arr1, l1 + n/2, r1, arr2, l2, l2 + n/2);
			else
				return medianSameLenHelper(arr1, l1 + (n - 1)/2, r1, arr2, l2, l2 + (n - 1)/2 + 1);
		}
		
	}
	
	
	public int medianDiffLen(int[] arr1, int[] arr2){
		int len1 = arr1.length;
		int len2 = arr2.length;
		return medianDiffLenHelper(arr1, 0, len1 - 1, arr2, 0, len2 - 1);
		
	}
	
	public int medianDiffLenHelper(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2){
		
		int len1 = r1 - l1 + 1;
		int len2 = r2 - l2 + 1;
		
		if(len1 == 1){
			if(len2 == 1){
				return (arr1[l1] + arr2[l2]) / 2;
			}
			if(len2 == 2){
				if(arr1[l1] < arr2[l2]){
					return arr2[l2];
				}else if(arr1[l1] < arr2[r2]){
					return arr1[l1];
				}else
					return arr2[r2];
			}
		}
		
		if(len1 == 2){
			
		}
		
		
		int m1 = (r1 - l1)/2;
		int m2 = (r2 - l2)/2;
		
		if(arr1[m1] <= arr2[m2]){
			return medianDiffLenHelper(arr1, m1, r1, arr2, l2, r2 - m1 + l1);
		}else{
			return medianDiffLenHelper(arr1, l1, m1, arr2, l2 + r1 - m1, r2);
		}
	}
	
	public static void main(String args[]){
		MedianOfArray test = new MedianOfArray();
		 int arr1[] = {1, 12, 15, 26, 38};
		 int arr2[] = {2, 13, 17, 30, 45};
		System.out.println(test.medianSameLen(arr1, arr2));
	}
}
