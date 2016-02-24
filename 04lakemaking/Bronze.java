import java.util.Scanner;
import java.io.*;

public class Bronze{
    public int[][]field;
   
    public Bronze(int row, int col){
	field= new int [row][col];
    }
    
    public void stomp(int row,int col, int depth){
	if (row+2>field.length || col+2>field[0].length){
	    System.out.println("A herd of cows didn't fit!");
	    return;
	}
	int highest=0;
	//checks for largest number
	for (int x=0; x<3; x++){
	    for (int y=0;y<3;y++){
		if (field[row+x-1][col+y-1]>highest){
		    highest=field[row+x-1][col+y-1];
		}
	    }
	}
	//checks if number is less than elevation - depth
	//and if it is, set it to difference
	for (int x=0; x<3; x++){
	    for (int y=0;y<3;y++){
		if (field[row+x-1][col+y-1]>highest-depth){
		    field[row+x-1][col+y-1]=highest-depth;
		}
	    }
	}
	//System.out.println(toString());
    }

    public void calculate(int elevation){
	int[][]after;
	after = new int[field.length][field[0].length];
	int sum=0;
	for (int row=0; row< field.length; row++){
	    for (int col=0;col< field[0].length;col++){
		if (field[row][col]-elevation<0){
		    after[row][col]= elevation - field[row][col];
		}
		else{
		    after[row][col]=0;
		}
	    }
	}

	for(int x=0;x<field.length;x++){
	    for(int y=0; y<field[0].length;y++){
		sum += after[x][y];
	    }
	}
	System.out.println(""+ sum * 72 * 72 + ",7,Chiu,Daniel");
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < field.length; r++){
	    for(int c = 0; c < field[0].length; c++){
		ans+= field[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String []args) throws IOException{
	File file= new File ("input.txt");
	Scanner sc = new Scanner (file);
	int a=sc.nextInt();
	int b=sc.nextInt();
	int c=sc.nextInt();
	int d=sc.nextInt();
	Bronze z= new Bronze(a,b);
	for (int row=0; row<a;row++){
	    for (int col=0; col<b;col++){
		z.field[row][col]=sc.nextInt();
	    }
	}
	//System.out.println(z);
	while (d>0){
	    z.stomp(sc.nextInt(),sc.nextInt(),sc.nextInt());
	    d--;
	}
	z.calculate(c);
    }
    
}
