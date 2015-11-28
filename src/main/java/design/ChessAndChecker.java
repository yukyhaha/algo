abstract class Piece{
	int color;
    int position;//position
    Player player;
    abstract isValidMove();
    //setter,getter
}

all types extend abstract class Peiece;

public class Player{
	String name;
	result;
}


public Class Game{
		Piece[][]board;
		Player[] players = new Player[2];
		boolean end;
		void initialBoard(){

			//inital all types on the board;
		}
		
		public boolean move(int fromx, int fromy, int tox, int toy, Player palyer){
			Piece p = board[fromx][fromy];
			if(!p.isValidMove(fromx, fromy, tox, toy)){
				player.popInvalideInfo();
				return false;
			}

			if(board[tox][toy] == null){
				board[tox][toy] = board[fromx][fromy];
				board[tox][toy] = null;
				return true;
			}else{
				if(board[tox][toy].getPlayer() == player){
					player.popInvalideInfo();
					return false;
				}else{
					if(board[tox][toy] instanceof king){
						end = true;
						return true;
					}else{
                        board[tox][toy] = board[fromx][fromy];
				        board[tox][toy] = null;
						return true;
					}
				}
			}
		}

		public play(){
			boolean flag=false;
			while(!false){
			for(int i = 0; i < 2; i ++){
				while(true){
					if(move(fromx, fromy, tox, toy, players[i])){
						if(end == true){
							player[i].setResult(true);
							player[(i + 1)%2].setResult(false);
							flag = ture;
						}
						break;
					}
				}
			}
			}
		}

		



}