package main.java.geeksforgeeks;

public class MatrixChainMultiplication {
	public MatrixChainMultiplication(){}
	
	public int getResultsRecursive(int[] matrix, int start, int end){
		if(start == end){
			return 0;
		}
		int minRes = Integer.MAX_VALUE;		
		for(int i = start; i < end; i ++){
			int tmpRes = getResultsRecursive(matrix, start, i) + getResultsRecursive(matrix, i + 1, end) + matrix[start - 1] * matrix[i] * matrix[end];
			
			minRes = Math.min(minRes, tmpRes);
		}
		return minRes;
	}
	
	public int getResultsDynamicMem(int[] matrix, int start, int end, int[][] memTable){
		if(start == end){
			return 0;
		}
		int minRes = Integer.MAX_VALUE;		
		for(int i = start; i < end; i ++){
			int tmpRes;
			if(memTable[start][end] == 0){
			    tmpRes = getResultsDynamicMem(matrix, start, i, memTable) + getResultsDynamicMem(matrix, i + 1, end, memTable) + matrix[start] * matrix[i + 1] * matrix[end + 1];
			}else{
				tmpRes = memTable[start][i] + memTable[i + 1][end] + matrix[start] * matrix[i + 1] * matrix[end + 1];
			}
			
			minRes = Math.min(minRes, tmpRes);
		}
		memTable[start][end] = minRes;
		return minRes;
	}
	
	public int getResutlsDynamicTab(){
		for(int )
	}
	
	
	public static void main(String args[]){
		MatrixChainMultiplication test = new MatrixChainMultiplication();
		int[] matrix =   {40, 20, 30, 10, 30} ;
		int[][] memTable = new int[matrix.length - 1][matrix.length - 1];
		System.out.println(test.getResultsDynamic(matrix, 0, matrix.length - 2, memTable));
	}
}
