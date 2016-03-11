import java.util.Arrays;
import java.util.Random;

public class Quick{
    /*
    private static int partition(int[]data, int left, int right){
	int[]temp = new int[data.length];
	int randomnum= left+(int)(Math.random()*((right-left)+1));
	int leftcount=0;
	int rightcount=0;
	int leftpos=0;
	int rightpos=0;
	int length= temp.length-1;
	int lucky= data[randomnum];
	System.out.println(lucky);
	while (leftcount+rightcount<length){
	    if (lucky>=data[leftcount]){
		    temp[leftcount]=data[leftpos];
		    leftcount++;
		    leftpos++;
	    }
	    else if (lucky<data[leftcount]){
		    temp[leftcount]=data[length-rightpos];
		    leftcount++;
		    rightpos++;
	    }
	    if (lucky>data[length-rightcount]){
		temp[length-rightcount]=data[leftpos];
		rightcount++;
		leftpos++;
	    }
	    else if (lucky<data[length-rightcount]){
		temp[length-rightcount]=data[length-rightpos];
		rightcount++;
		rightpos++;
	    }
	}
	System.out.println(Arrays.toString(temp));
	System.out.println(leftpos);
	temp[leftpos]=lucky;
	data=temp;
	return leftpos-1;
    }
    */
    
    public static void swap(int [] data, int x, int y){
	int temp;
	temp = data[x];
	data[x]=data[y];
	data[y]=temp;
    }

    private static int partition(int[]data, int left, int right){
	int randomnum= left+(int)(Math.random()*((right-left)+1));
	int pivot= data[randomnum];
	int wall=left;
	int currentpos=left;
	//System.out.println(pivot);
	swap(data,randomnum,data.length-1);
	while (currentpos<right){
	    if (pivot < data[currentpos]){
		currentpos++;
	    }
	    if (pivot>data[currentpos]){
		swap(data,wall,currentpos);
		wall++;
		currentpos++;
	    }
	    //System.out.println(Arrays.toString(data));
	}
	swap(data,wall,currentpos);
	return wall;
    }
    
    public int quickselect(int []data,int k){
	return quickselect(data,k,0,data.length-1);
    }
   
    public int quickselect(int []data,int k,int left, int right){
	if (left == right){
	    return data[left];
	}
	int x= partition(data,left,right);
	if (x==k){
	    return data[k];
	}
	if (x>k){
	    return quickselect(data,k,left,x-1);
	}
	else{
	    return quickselect(data,k,x+1,right);
	}
    }

    public static void main(String[]args){
	Quick test= new Quick();
	int[]x={1,9,5,7,3,2};
	System.out.println(test.quickselect(x,2));
	//test.quickselect(x,4);
	System.out.println(Arrays.toString(x));
    }

}
