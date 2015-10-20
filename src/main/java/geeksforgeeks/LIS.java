package main.java.geeksforgeeks;

public class LIS {
	public LIS(){}
	
	public int doLISRecursive(int[] arr){
		
	}
	
	public int doLISRecursiveHelper(int[] arr, int n){
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++){
			maxLen = Math.max(doLISRecursiveHelper(arr, i), maxLen);
		}
	}
	
	
}
