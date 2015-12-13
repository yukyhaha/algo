package main.java.algo;

public class CoinsChange {

	public CoinsChange() {
		// TODO Auto-generated constructor stub
	}
	
	public int changeWays(int[] s, int n){
	
		int len = s.length;
		int dp[][] = new int[n + 1][len];
	
		for(int i = 0; i < len; i ++){
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < n + 1; i ++){
			for(int j = 0; j < len; j ++){
				int x = i - s[j] >= 0 ? dp[i - s[j]][j] : 0;
				int y = j - 1 >=0 ? dp[i][j - 1] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[n][len - 1];
	}		

	public static void main(String args[]){
		CoinsChange t = new CoinsChange();
		int[] s= {1, 2, 3};
		System.out.println(t.changeWays(s, 4));
	}
}
