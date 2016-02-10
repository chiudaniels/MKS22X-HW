public class board{
    int [][] board;
    public board(int n){
	board=new int [n][n];
	fillInit();
    }
    public void fillInit(){
	for (int x=0;x<board.length;x++){
	    for (int y=0;y<board[0].length;y++){
		board[x][y]=0;
	    }
	}
    }
    public boolean placeQueen(int x, int y){
	if (board[x][y] == 0){
	    board[x][y] = 1;
	    return true;
	}
	else{
	    return false;
	}
    }
}
