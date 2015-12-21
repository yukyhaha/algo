package main.java.algo;

public class boardIsland2 {

	public boardIsland2() {
		// TODO Auto-generated constructor stub
	}
	
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0)
            return;
            
        int n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O' && !mark[i][j]){
                    check(board, mark, i, j);
                }
            }
        }
    }
    
    public void check(char[][] board, boolean[][] mark, int i, int j){
            if(board[i][j] == 'O' && !mark[i][j]){
                mark[i][j] = true;
                
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1){
                    return;
                }
            
                check(board, mark, i + 1, j);
                check(board, mark, i, j + 1);
                check(board, mark, i - 1, j);
                check(board, mark, i, j - 1);
                
                if((board[i][j - 1] == 'X' || mark[i][j - 1]) && (board[i][j + 1] == 'X' || mark[i][j + 1])
                     && (board[i - 1][j] == 'X' || mark[i - 1][j]) && (board[i + 1][j] == 'X' || mark[i + 1][j])){
                         
                         board[i][j] = 'X';
                     }
            }
                
                
            
    }
    
    public static void main(String args[]){
    	boardIsland2 t = new boardIsland2();
    	char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X','X','O','X'},{'X','O','X','X'}};
    	t.solve(board);
    	for(int i = 0; i < 4; i ++){
    		for(int j = 0; j < 4; j ++){
    			System.out.println(board[i][j]);
    		}
    	}
    }

}
