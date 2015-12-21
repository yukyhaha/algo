package main.java.algo;

public class MatixIsland {

	public MatixIsland() {
		// TODO Auto-generated constructor stub
	}
	
	public int islandsNum(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		boolean mark[][] = new boolean[m][n];
		int count = 0;
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				if(matrix[i][j] == 1 && !mark[i][j]){
					count ++;
					visitIsland(matrix, mark, i, j);
				}
			}
		}
		return count;
	}
	
	public void visitIsland(int[][] matrix, boolean[][] mark, int i, int j){
		mark[i][j] = true;
		if(i > 0 && matrix[i - 1][j] == 1 && !mark[i - 1][j]){
			visitIsland(matrix, mark, i - 1, j);
		}
		
		if(i + 1 < matrix.length && matrix[i + 1][j] == 1 && !mark[i + 1][j]){
			visitIsland(matrix, mark, i + 1, j);
		}
		
		if(j > 0 && matrix[i][j - 1] == 1 && !mark[i][j - 1]){
			visitIsland(matrix, mark, i, j - 1);
		}
		
		if(j + 1< matrix[0].length && matrix[i][j + 1] == 1 && !mark[i][j + 1]){
			visitIsland(matrix, mark, i, j + 1);
		}
	}
	
	
	public static void main(String args[]){
		MatixIsland t = new MatixIsland();
		int[][] matrix = {{0, 1, 0},{0, 1, 0},{0, 1, 0}};
		System.out.println(t.islandsNum(matrix));
	}

}
