public class Cell{
	public int num;
	public boolean isMine;
	public boolean isFlag;
	public boolean isRevealed;
	public Cell(){}
	setter/getter
}
public class MS{
	private int m;
	private int n;
	private int numOfMine;
	private Cell[][] board;
	public MS(int m, int n, int numOfMine){
		this.m = m;
		this.n = n;
		this.numOfMine = numOfMine;
	}
	
	public void createGame(int m, int n, int numOfMine){
		board = new Cell[m][n];
		//initiate array
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				board[i][j] = new Cell();
			}
		}
		for(int i = 0; i < numOfMine; i ++){
			int rm = randome(0, m);
			int rn = randome(0, n);
			if(board[rm][rn].isMine == false){
				board[rm][rn].isMine = true;
				if(rm > 0){
					board[rm - 1][rn].num ++;
				}

				if(rm < m - 1){
					board[rm + 1][rn].num ++;
				}

				if(rn > 0){
					board[rm][rn - 1].num ++;
				}

				if(rn < n - 1){
					board[rm][rn + 1].num ++;
				}

				if(rm > 0 && rn > 0){
					board[rm - 1][rn - 1].num ++;
				}

				if(rm < m - 1 && rn < n - 1){
					board[rm + 1][rn + 1].num ++;
				}

				if(rm > 0 && rn < n - 1){
					board[rm - 1][rn + 1].num ++;
				}

				if(rm < m - 1 && rn > 0){
					board[rm + 1][rn - 1].num ++;
				}

			}else{
				i--;
			}
		}




	}

	public void revealGrids(int i, int j){
		
		board[i][j].isRevealed = true;

		if(board[i][j].num != 0)
			return;
		if(i > 0 && !board[i - 1][j].isRevealed){
			revealGrids(i-1, j);
		}

		if(i < m - 1  && !board[i + 1][j].isRevealed){
			revealGrids(i+1, j);
		}

		if(j > 0  && !board[i][j - 1].isRevealed){
			revealGrids(i, j - 1);
		}

		if(j < n - 1  && !board[i][j +1].isRevealed){
			revealGrids(i, j + 1);
		
		if(i > 0 && j > 0  && !board[i - 1][j - 1].isRevealed){
			revealGrids(i-1, j - 1); 
		}

		if(i < m - 1 && j < n -1  && !board[i + 1][j + 1].isRevealed){
			revealGrids(i + 1, j + 1);
		}

		if(i > 0 && j < n - 1  && !board[i - 1][j + 1].isRevealed){
			revealGrids(i-1, j + 1);
		}

		if(i < m - 1 && j > 0  && !board[i +1][j - 1].isRevealed){
			revealGrids(i-1, j - 1);
		}


	}
	
	public void leftClick(int i, int j){
		if(board[i][j].isMine){
			expode();
		}else{
			//recursive function to reaveal i, j and surroundings untill the grid is not 0
			revealGrids(i, j);
		}
	}
	
	public void rightClick(int i, int j){
		board[i][j].isFlag = true;
	}
	
	public void expode(){
	}
}