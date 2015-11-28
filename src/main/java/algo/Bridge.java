package main.java.algo;

/*
 * Q1) Dynamic Programming | Set 21 (Variations of LIS) – GeeksforGeeks -> 1. 
 * Building Bridges: Consider a 2-D map with a horizontal river passing through 
 * its center. There are n cities on the southern bank with x-coordinates a(1) … a(n) 
 * and n cities on the northern bank with x-coordinates b(1) … b(n). You want to connect 
 * as many north-south pairs of cities as possible with bridges such that no two bridges 
 * cross. When connecting cities, you can only connect city i on the northern bank to city 
 * i on the southern bank.
 * */

public class Bridge {

	public Bridge() {
		// TODO Auto-generated constructor stub
	}
	
	public int maxBridge(int[] a, int[] b){
		int len = a.length;
		int dp[][] = new int[len][len];
		
		for(int i = 0; i < len - 1; i ++){
			if((a[i] < a[i + 1] && b[i] < b[i + 1]) || (a[i] < a[i + 1] && b[i] < b[i + 1])){
				dp[i][i + 1] = 2;
			}else{
				dp[i][i + 1] = 1;
			}
		}
		
		for(int i = 3; i <= len; i ++){
			for(int j = 0; j <= len - i; j ++){
				int end = j + i - 1;
				if(dp[j + 1][end - 1] == dp[j + 1][end] && dp[j + 1][end] == dp[j][end - 1]){
					dp[j][end] = dp[j + 1][end - 1] + 1;
				}else{
					dp[j][end] = Math.max(dp[j + 1][end], dp[j][end - 1]);
				}
			}
		}
		
		return dp[0][len - 1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bridge test = new Bridge();
		int arr1[] = { 7, 4, 3, 6, 2, 1, 5};
		int arr2[] = { 5, 3, 2, 4, 6, 1, 7};
		System.out.println(test.maxBridge(arr1, arr2));
	}

}
