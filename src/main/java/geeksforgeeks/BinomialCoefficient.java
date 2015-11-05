package main.java.geeksforgeeks;

public class BinomialCoefficient {
	public int count = 0;
	public BinomialCoefficient(){
		
	}
	public void getResults(int n, int k, int start){
		if(k == 0){
			count ++;
			return;
		}
		for(int i = start; i <= n - k; i ++){
			getResults(n, k - 1, i + 1);
		}
	}
	public static void main(String args[]){
		BinomialCoefficient bc = new BinomialCoefficient();
		bc.getResults(5, 4, 0);
		System.out.println(bc.count);
	}
}
