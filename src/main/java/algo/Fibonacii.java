package main.java.algo;

public class Fibonacii {

	public Fibonacii() {
		// TODO Auto-generated constructor stub
	}

	public int recursive(int n){
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		return recursive(n - 1) + recursive(n - 2);
	}
	
	public int iterate(int n){
		int f1 = 0;
		int f2 = 1;
		int tmp = 0;
		for(int i = 2; i < n; i ++){
			tmp = f2;
			f2 = f1 + f2;
			f1 = tmp;
		}
		return f2;
	}
	
	public int memDp(int n){
		int dp[] = new int[n];
		for(int i = 0; i < n; i ++){
			dp[i] = -1;
		}
		return memDpHelper(dp, n);	
	}
	
	public int memDpHelper(int[] dp, int n){
		if(n == 1){
			return 0;
		}
		
		if(n == 2){
			return 1;
		}
		int f1 = dp[n - 2];
		int f2 = dp[n - 3];
		if(f1 == -1){
			f1 = memDpHelper(dp, n - 1);
		}
		if(f2 == -1){
			f2 = memDpHelper(dp, n - 2);
		}
		return f1 + f2;		
	}
	
	public static void main(String args[]){
		Fibonacii f = new Fibonacii();
		System.out.println(f.recursive(5));
		System.out.println(f.iterate(5));
		System.out.println(f.memDp(5));
	}
}
