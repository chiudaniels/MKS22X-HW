public class KnightBoard{
    int[][]board;
    public KnightBoard(int n){
	 board =new int [n][n];
    }

    public boolean knightMove(int n,int count, int xpos, int ypos){
	if (n==0 &&  xpos + 2 < board.length && ypos+3 < board[0].length && board[xpos+2][ypos+3]==0){
	    board[xpos+2][ypos+3]=count;
	    return true;
	}
	if (n==1 && xpos -2 > board.length && ypos +3 < board[0].length && board[xpos-2][ypos+3]==0 ){
	     board[xpos-2][ypos+3]=count;
	     return true;
	}
	if (n==2 && xpos + 3 < board.length && ypos+2 < board[0].length && board[xpos+3][ypos+2]==0){
	     board[xpos+3][ypos+2]=count;
	     return true;
	}
	if (n==3  && xpos + 3 < board.length && ypos-2 > board[0].length && board[xpos+3][ypos-2]==0){
	     board[xpos+3][ypos-2]=count;
	     return true;
	}
	if (n==4 && xpos + 2 < board.length && ypos-3 > board[0].length && board[xpos+2][ypos-3]==0){
	     board[xpos+2][ypos-3]=count;
	     return true;
	}
	if (n==5 && xpos - 2 > board.length && ypos-3 > board[0].length && board[xpos-2][ypos-3]==0){
	     board[xpos-2][ypos-3]=count;
	     return true;
	}
	if (n==6 && xpos-3 > board.length && ypos+2 < board[0].length && board[xpos-3][ypos+2]==0 ){
	     board[xpos-3][ypos+2]=count;
	     return true;
	}
	if (n==7 && xpos -3 > board.length && ypos-2 > board[0].length && board[xpos-3][ypos-2]==0 ){
	     board[xpos-3][ypos-2]=count;
	     return true;
	}
	return false;
    }

     public static void main(String[]args){
	KnightBoard b = new KnightBoard(5);
	System.out.println(b.knightMove(5,1,0,0));
     }
}
