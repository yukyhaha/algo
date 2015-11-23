package main.java.geeksforgeeks;

public class PartitionProblem {

	public PartitionProblem() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean hasSumRecursive(int[] arr){
		int sum = 0;
		int n = arr.length;
		for(int i = 0; i < n; i ++){
			sum += arr[i];
		}
		if(sum%2 == 1)
			return false;
		else
			return hasSumRecursiveHelper(arr, n, sum/2);
		
	}
	
	public boolean hasSumRecursiveHelper(int[] arr, int n, int sum){
		if(n == 0){
			if(sum == 0)
				return true;
			else
				return false;
		}
		return hasSumRecursiveHelper(arr, n - 1, sum) 
				|| hasSumRecursiveHelper(arr, n - 1, sum - arr[n - 1]);
	}
	
	public boolean hasSumDynamic(int[] arr){
		int sum = 0;
		int n = arr.length;
		for(int i = 0; i < n; i ++){
			sum += arr[i];
		}
		
		if(sum%2 == 1)
			return false;
		boolean[][] dp = new boolean[sum/2 + 1][n + 1];

		
		for(int i = 0; i <= n; i ++){
			dp[0][i] = true;
	}
		
		for(int i = 0; i <= sum/2; i ++){
			for(int j = 1; j <= n; j ++){
				
				dp[i][j] = dp[i][j - 1];
				if(i - arr[j - 1] >= 0)
					dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
			}
		}
		
		return dp[sum/2][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionProblem test = new PartitionProblem();
		int[] arr =  {3, 1, 1, 2, 2, 1};
		System.out.println(test.hasSumDynamic(arr));
		System.out.println(test.hasSumRecursive(arr));
	}

}
