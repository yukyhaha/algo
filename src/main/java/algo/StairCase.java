package main.java.algo;

public class StairCase {

	public StairCase() {
		// TODO Auto-generated constructor stub
	}
	public int getAllWays(int n, int[] m){
		
		return getAllWaysHelper(n, m, m.length);
	}
	
	public int getAllWaysHelper(int n, int[] m, int l){
		if(n == 0)
			return 1;
		if(l < 1){
			return 0;
		}
		if(n < 0)
			return 0;
		return getAllWaysHelper(n - m[l - 1], m, l) + getAllWaysHelper(n, m ,l - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StairCase t = new StairCase();
		int[] m = {1, 2, 3};
		System.out.print(t.getAllWays(5, m));
	}

}
