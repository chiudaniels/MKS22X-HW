public class KnightBoard{
    int[][]board;
    int index = 0;
    
    public KnightBoard(int n){
	 board =new int [n][n];
    }

    public KnightBoard(int x, int y){
	board = new int[x][y];
    }
    
    public boolean knightMove(int count, int xpos, int ypos){
	if (board.length != board[0].length && ((board.length%2 != 0 && board[0].length%2 != 0) || (board.length== 1||board.length==2||board.length==4)|| (board.length==3 && (board[0].length ==4 || board[0].length==6 || board[0].length==8)))){
	    return false;
	}
	if (index > board.length * board[0].length){
	    return true;
	}
	if (board[xpos][ypos] !=0){
	   return false;
	}
	board[xpos][ypos]=index++;
	 //up and right THESE COMMENTS ARE ALL WRONG WHY DID I WASTE MY TIME
	if ((xpos + 1 < board.length && ypos+ 2 < board[0].length && board[xpos+1][ypos+2]==0)&& knightMove(count+1,xpos+1,ypos +2)){
	    return true;
	}
	//up and left
	if ((xpos -1 >= 0 && ypos + 2 < board[0].length && board[xpos-1][ypos+2]==0 )&& knightMove(count+1,xpos-1,ypos +2)){
	     return true;
	}
	//left and up
	if ((xpos + 2 < board.length && ypos+1 < board[0].length && board[xpos+2][ypos+1]==0)&& knightMove(count+1,xpos+2,ypos +1)){
	     return true;
	}
	//left and down
	if ((xpos + 2 < board.length && ypos-1 >=0 && board[xpos+2][ypos-1]==0)&& knightMove(count+1,xpos+2,ypos -1)){
	     return true;
	}
	//left and up
	if ((xpos + 1 < board.length && ypos-2 >= 0 && board[xpos+1][ypos-2]==0)&& knightMove(count+1,xpos+1,ypos -2)){
	     return true;
	}
	//left and down
	if ((xpos - 1 >= 0 && ypos-2 >= 0 && board[xpos-1][ypos-2]==0)&& knightMove(count+1,xpos-1,ypos -2)){
	     return true;
	}
	if ((xpos-2 >= 0 && ypos+1 < board[0].length && board[xpos-2][ypos+1]==0 )&& knightMove(count+1,xpos-2,ypos +1)){
	     return true;
	}
	if ((xpos -2 >=0 && ypos-1 >= 0 && board[xpos-2][ypos-1]==0 )&& knightMove(count+1,xpos-2,ypos -1)){
	     return true;
	}
	
	return false;
    }
    
    public boolean solve(){
	return knightMove(0,0,0);
    }

    /* public boolean solveH(int count, int xcor, int ycor){
	if (count>= board.length*board[0].length-1)
	while (index > board.length* board[0].length -1){
	}
	}*/

    public void printSolution(){
	String ans= "";
	if (board.length * board[0].length <10){
	    for (int row=0;row < board.length; row++){
		for (int col=0; col < board[0].length; col++){
		    ans += board[row][col] +" ";
		}
		ans += "\n";
	    }
	}
	else{
	    for (int row=0;row < board.length; row++){
		for (int col=0; col < board[0].length; col++){
		    if (board[row][col] > 9){
			ans += board[row][col] +" ";
		    }
		    else{
			ans += "_"+board[row][col] +" ";
		    }
		}
		ans += "\n";
	    }
	}
	if (board[board.length-1][board[0].length-1] ==0){
	    ans="No possible tour found for current board setup";
	}
	System.out.println(ans);
    }

     public static void main(String[]args){
	 KnightBoard b = new KnightBoard(4,7);
	b.solve();
	b.printSolution();
        //System.out.println(b.solve());
	//System.out.println(b.knightMove(5,1,0,0));
     }
}
