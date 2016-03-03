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

    public boolean isOutBounds(int x, int y){
	if (x-1<0 || x+1>field.length || y-1<0 || y+1>field[0].length){
	    return false;
	}
	return true;
    }

    public boolean move(int x,int y){
	int [][]temp= new int[field.length][field[0].length];
	if (field [x][y] == -1 || field[x][y]==0){
	    return false;
	}
	if (x-1<0 || field[x-1][y]==-1){
	    temp[x+1][y]+= field[x][y] ;
	}
	if (x+1>field.length || field[x+1][y]==-1){
	    temp[x-1][y] += field[x][y] ;
	}
	if (y-1<0 || field[x][y-1]==-1){
	    temp[x][y+1] += field[x][y] ;
	}
	if (y+1>field.length || field[x][y+1]==-1){
	    temp[x][y-1] += field[x][y] ;
		}
	if (x !=0 && x != field.length && field[x-1][y]!=-1 && field[x+1][y]!=-1){
	    temp[x+1][y]+= field[x][y];
	    temp[x-1][y] += field[x][y] ;
	}
	if (y !=0 && y != field.length && field[x][y-1]!=-1 && field[x][y+1]!=-1){
	   temp[x][y+1] += field[x][y] ;
	   temp[x][y-1] += field[x][y] ;
	}
	field=temp;
	for (int a=0;a<temp.length;a++){
	    for(int b=0;b<temp[0].length;b++){
		field[a][b]+=temp[a][b];
	    }
	}
	 System.out.println(toString());
	field[x][y]=0;
	return true;
    }

    public int solve(){
	for (int t= time; t>0;t--){
	    for (int x=0;x<field.length-1;x++){
		for (int y=0;y<field[0].length-1;y++){
		    move(x,y);
		}
	    }
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
	x.solve();
	//System.out.println(x.solve());
	System.out.println(x);
    }
}
