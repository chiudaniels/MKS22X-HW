import java.util.*;
import java.io.*;

public class Silver{
    int [][] field;
    int xstart;
    int ystart;
    int time;
    int xend;
    int yend;

    public Silver(String filename){
	File file= null;
	Scanner sc= null;
	int height;
	int length;
	try{
	    file=new File(filename);
	    sc = new Scanner (file);
	    
        }
	catch (FileNotFoundException e){
	}
	height=sc.nextInt();
	length=sc.nextInt();
	time=sc.nextInt();
	field = new int [height][length];
	String temp ="";
	for (int x=0;x<height+1;x++){
	    temp += sc.nextLine();
	}
	int pos=0;
        for (int row=0; row<field.length; row++){
	    for (int col=0; col<field[0].length; col++){  
		if(temp.charAt(pos)=='*'){
		    field[row][col]=-1;
		}
		pos++;
	    }
	}
	xstart= sc.nextInt() -1;
	ystart= sc.nextInt()-1;
	xend= sc.nextInt()-1;
	yend= sc.nextInt()-1;
	field[xstart][ystart]=1;
    }

    public void move(){
	int [][]temp= new int[field.length][field[0].length];
	int count=0;
	for (int x=0;x<field.length;x++){
	    for (int y=0;y<field[0].length;y++){
		count =0;
		if (field[x][y]==0){
		    if (x>0 && field[x-1][y]> 0){
			count += temp[x-1][y];
		    }
		    if(x<field.length-1 && field[x+1][y]>0){
			count += temp[x+1][y];
		    }
		    if (y>0 && field[x][y-1] > 0){
			count += temp[x][y-1];
		    }
		    if(y<field.length-1 && field[x][y+1]>0){
			count += temp[x][y+1];
		    }
		    if (field[x][y] != -1){
			temp[x][y]=count;
		    }
		}
		System.out.println(toString());
	    }
	}
	field = temp;
    }

    public int solve(){
	for (int t= 0; t<=time;t++){
	    move();
	}

	return field[xend][yend];
    }
    
    public String toString(){
	String ans = "";
	for(int r = 0; r <field.length; r++){
	    for(int c = 0; c < field[0].length; c++){
		ans+= field[r][c]+" ";
	    }
	    ans+="\n";
	}
	return ans;
    }


    public static void main(String[]args){
	Silver x= new Silver("ctravel.in");
	x.move();
	//x.solve();
	System.out.println(x.time);
	//System.out.println(x.solve());
	System.out.println(x);
    }
}
