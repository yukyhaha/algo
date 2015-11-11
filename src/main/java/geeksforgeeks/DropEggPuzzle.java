package main.java.geeksforgeeks;

public class DropEggPuzzle {
	
	public DropEggPuzzle(){}
	
	public int getMinTrials(int n, int k){
		int[][] dp = new int[n + 1][k + 1];
		int res;
		for(int i = 1; i <= k; i ++){
			dp[1][i] = i;			
		}
		for(int i = 1; i <= n; i ++){		
		   dp[i][1] = 1;
		}
		for(int i = 2; i <= n; i ++){
			for(int j = 2; j <= k; j ++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int x = 1; x <= j; x ++){
					res = Math.max(dp[i - 1][x - 1], dp[i][j - x]) + 1;
					dp[i][j] = Math.min(dp[i][j], res);                   
				
				}
			}
		}
		
		return dp[n][k];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DropEggPuzzle test = new DropEggPuzzle();
		System.out.println(test.getMinTrials(2, 36));

	}

}
