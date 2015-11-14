package main.java.careercup;

import java.util.ArrayList;


/*
 * http://www.careercup.com/question?id=4816567298686976
 * Given a prime set, we call "prime expressible" if a number can be 
 * factorized only using given prime numbers. Find n-th big expressible number. 

E.g., prime set = {2, 3} 
expressible number = {1,2,3,4,6,8, 9, 12...} 
non-expressible number = {5, 10... } 

The primes in the prime set are ordered in an increasing order, and can 
include a prime < 10^4 (don't remember the exact range), and n can also be as large as 1-10^6.


 * 
 * */

public class ExpressiveNum {
	public ExpressiveNum(){}

	public void getExpressiveNum(int[] primeSet, int n){
		int[] lastIndex = new int[n];
		int result[] = new int[n + 1];
		int partialResult[] = new int[primeSet.length];
		result[0] = 1;
		
		for(int i = 1; i < n + 1; i ++){
			result[i] = result[lastIndex[0]] * primeSet[0];
			int minIndex = 0;
			partialResult[0] = result[i];
			for(int j = 1; j < primeSet.length; j ++){
				partialResult[j] = result[lastIndex[j]] * primeSet[j]; 
				if (partialResult[j] < result[i]){					
					result[i] = partialResult[j];
					minIndex = j;
				}
			}
			
			for(int j = 0; j < primeSet.length; j ++){
				if(partialResult[j] == partialResult[minIndex]){
					lastIndex[j] ++;
				}
			}
			
		}
		
		for(int i = 0; i < n + 1; i ++){
			System.out.println(result[i]);
		}
     }
	
	public static void main(String args[]){
		ExpressiveNum test = new ExpressiveNum();
		int[] primeSet = {2, 3, 6, 8};
		test.getExpressiveNum(primeSet, 10);
	}
}