import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
	//matthew helped me with this part
	File file = null;
	Scanner sc= null;
	Scanner scheight=null;
	Scanner sclength=null;
	animate = ani;
	//
	try{
	    file=new File("data1.dat");
	    sc = new Scanner (file);
	    scheight= new Scanner (file);
	    sclength= new Scanner (file);
	    
        }
	catch (FileNotFoundException e){
	}
	int length= sclength.nextLine().length();
	int height =0;
        while (scheight.hasNextLine()){
	    height ++;
	    scheight.nextLine();
	}
	maze= new char [height][length];
	String temp ="";
	while (sc.hasNextLine()){
	    temp += sc.nextLine();
	}
	int pos=0;
        for (int row=0; row<maze.length; row++){
	    for (int col=0; col<maze[0].length; col++){  
		maze[row][col]=temp.charAt(pos);
		pos++;
	    }
	}
	for (int row=0; row<maze.length; row++){
	    for (int col=0; col<maze[0].length; col++){  
		if(maze[row][col]=='S'){
		    startx= row;
		    starty= col;
		}
	    }
	}
	//System.out.println(temp);
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */

    private boolean solve(int posx, int posy){
	if(animate){
            System.out.println(this);
            wait(20);
        }

	if (maze[posx][posy] == 'E'){
	    return true;
	}
	if (maze[posx][posy] == '#' || maze[posx][posy]=='@' || maze[posx][posy]=='.'){
	    return false;
	}
	maze[posx][posy]='@';
	if (posx+1<maze.length && solve(posx+1,posy)){
	    //System.out.println(maze[posx+1][posy]);
	    return true;
	}
	if (posy+1<maze[0].length && solve(posx,posy+1)){
	    //System.out.println( maze[posx][posy+1]);
	    return true;
	}
	if (posx-1>=0 && solve(posx-1,posy)){
	    //System.out.println(maze[posx-1][posy]);
	    return true;
	}
	if (posy-1>=0 && solve(posx,posy-1)){
	    //System.out.println( maze[posx][posy-1]);
	    return true;
	}
	maze[posx][posy]='.';
	return false;
    }

    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
	}
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
 
	


    //FREE STUFF!!! *you should be aware of this*

    
    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }
    
    /*
    public String toString(){
	String ans = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		ans+= maze[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    */
    
    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";

        if(animate){

            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";

        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(33,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }


    //MORE FREE STUFF!!! *you can ignore all of this*

    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    

    //END FREE STUFF



}
