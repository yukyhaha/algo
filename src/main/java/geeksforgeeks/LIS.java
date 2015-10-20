package main.java.geeksforgeeks;

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
