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
		int maxLen = 0;		
		int[] dp = new int[len];
		for(int i = 0; i < len; i ++){
			dp[i] = 1;
		}
		for(int i = 1; i < len; i ++){
			for(int j = 0; j < i; j ++){
				if(dp[j] + 1 > dp[i] && arr[i] >= arr[j]){
					dp[i] = dp[j] + 1;
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		
		
		return maxLen;
	}
	
	public int getCeil(int[] tailTable, int num, int len){
		int l = 0, r = len;
		
		while(r - l > 1){
			int mid = l + (r - l)/2;

			if(tailTable[mid] < num){
				l = mid;
			}else{
				r = mid;
			}
		}
		return r;
		
	}
	
	public int doLISnlogn(int[] arr){
		int n = arr.length;
		int[] tailTable = new int[n];
		tailTable[0] = arr[0];
		int len = 1;
		for(int i = 1; i < n; i ++){
			if(arr[i] < tailTable[0]){
				tailTable[0] = arr[i];
			}else if(arr[i] >= tailTable[len - 1]){
				tailTable[len] = arr[i];
				len ++;
			}else{
				tailTable[getCeil(tailTable, arr[i], len - 1)] = arr[i];
			}
		}
		
		return len;
	}
	
	
	public static void main(String args[]){
		LIS lis = new LIS();
		int[] arr =  { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		System.out.println(lis.doLISDynamic(arr));
		System.out.println(lis.doLISnlogn(arr));
	}
	
	
}
