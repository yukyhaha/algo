package main.java.algo;

public class LPS {

	public LPS() {
		// TODO Auto-generated constructor stub
	}
	
	public int getLPS(String s){
		int len = s.length();
		if(len == 0)
			return 0;
		
		int[][]dp = new int[len][len];
		
		for(int i = 0; i < len; i ++){
				dp[i][i] = 1;
				
				if(i < len - 1 && s.charAt(i) == s.charAt(i + 1)){
					dp[i][i + 1] = 2;
				}else if(i < len - 1){
					dp[i][i + 1] = 1;
				}
		}
		
		for(int i = 3; i <= len; i ++){
			for(int j = 0; j < len - i + 1; j ++){
								
				if(s.charAt(j) == s.charAt(j + i - 1)){
					dp[j][j + i - 1] = dp[j + 1][i + j -2] + 2;
				}else{
					dp[j][j + i - 1] = Math.max(dp[j + 1][j + i - 1], dp[j][j + i - 2]);
				}
			}
		}
		
		return dp[0][len - 1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LPS test = new LPS();
		System.out.println(test.getLPS("GEEKSFORGEEKS"));
		

	}

}
