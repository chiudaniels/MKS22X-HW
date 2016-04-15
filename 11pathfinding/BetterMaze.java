import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	private Node prev;
	private int x,y;
	
	public Node(int row, int col, Node previous){
	    x=row;
	    y=col;
	    prev=previous;
	}

	public int getX(){
	    return x;
	}
	
	public int getY(){
	    return y;
	}

	public Node getPrev(){
	    return prev;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> frontier;
    private boolean animate;
    private Node solutionNode;

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        frontier  = new FrontierQueue();     
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        frontier = new FrontierStack();  
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
	Node start = new Node(startRow,startCol,null);
	move(startRow,startCol);
        while(frontier.hasNext()){
	    if (solution(frontier.peek().getX(),frontier.peek().getY())){
		solutionNode= frontier.peek();
		return true;
	    }
	    if(!move1(frontier.peek().getX(),frontier.peek().getY())
	       &&
	       !move2(frontier.peek().getX(),frontier.peek().getY())
	       &&
	       !move3(frontier.peek().getX(),frontier.peek().getY())
	       &&
	       !move4(frontier.peek().getX(),frontier.peek().getY())){
		frontier.next();
	    }
	}
	return false;
    }
    
    private boolean solution(int x, int y){
	return maze[x][y]=='E';
    }
    
    private boolean move1(int x, int y){
	if (maze[x][y] == ' '){
	    maze[x][y]='.';
	}
	boolean ans= true;
	if (maze [x+1][y] != '#' && maze [x+1][y] != '.'){
	    frontier.add(new Node(x+1,y,frontier.next()));
	}

	return ans;
    }
	
    private boolean move2(int x, int y){
	if (maze[x][y] == ' '){
	    maze[x][y]='.';
	}
	boolean ans= true;
	if (maze [x-1][y] != '#' &&  maze [x+1][y] != '.'){
	    frontier.add(new Node(x-1,y,frontier.next()));
	}
	return ans;
    }
	
    private boolean move3(int x, int y){
	if (maze[x][y] == ' '){
	    maze[x][y]='.';
	}
	boolean ans= true;
	if (maze [x][y+1] != '#' && maze [x+1][y] != '.'){
	    frontier.add(new Node(x,y+1,frontier.next()));
	}
	return ans
	    }
	
    private boolean move4(int x, int y){
	if (maze[x][y] == ' '){
	    maze[x][y]='.';
	}
	boolean ans= true;
	if (maze [x][y-1] != '#' && maze [x+1][y] != '.'){
	    frontier.add(new Node(x,y-1,frontier.next()));
	}
	return ans;
    }
		     
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
	

	}
