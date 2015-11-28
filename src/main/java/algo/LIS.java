package main.java.algo;
/*
 * The longest Increasing Subsequence (LIS) problem is to find the length 
 * of the longest subsequence of a given sequence such that all elements of
 *  the subsequence are sorted in increasing order. For example, length of LIS 
 *  for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * */
public class LIS {
	public LIS(){}
	public int maxLen = 1;
	public int doLISRecursive(int[] arr){		
		doLISRecursiveHelper(arr, arr.length - 1);
		return maxLen;
	}
	
	public int doLISRecursiveHelper(int[] arr, int n){
		if(n == 0)
			return 1;
		int maxHere = 1;
		for(int i = 0; i < n; i ++){
			int res = doLISRecursiveHelper(arr, i);
			if(arr[i] < arr[n] && res + 1 > maxHere){
				maxHere = res + 1;
			}
		}
		
		if(maxLen < maxHere){
			maxLen = maxHere;
		}
		
		return maxHere;
	}
	
	public int doLISDynamic(int[] arr){
		int len = arr.length;
		if(len == 0)
			return 0;
		int res = 1;
		for(int i = 0; i < len; i ++){
			int maxLen = 1;
			for(int j = i + 1; j < len; j ++){
				if(arr[j] >= arr[i]){
					maxLen ++;
				}
			}
			res = Math.max(res, maxLen);
		}
		return res;
	}
	
	
	public static void main(String args[]){
		LIS lis = new LIS();
		int[] arr =  { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(lis.doLISDynamic(arr));
	}
	
	
}
