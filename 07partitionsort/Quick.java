import java.util.Arrays;
import java.util.Random;

public class Quick{
    
    public static void swap(int [] data, int x, int y){
	int temp;
	temp = data[x];
	data[x]=data[y];
	data[y]=temp;
    }

    private static int partitionOld(int[]data, int left, int right){
	int randomnum= left+(int)(Math.random()*((right-left)+1));
	int pivot= data[randomnum];
	int wall=left;
	int currentpos=left;
	swap(data,randomnum,data.length-1);
	while (currentpos<right){
	    if (pivot <= data[currentpos]){
		currentpos++;
	    }
	    if (pivot>data[currentpos]){
		swap(data,wall,currentpos);
		wall++;
		currentpos++;
	    }
	}
	swap(data,wall,data.length-1);
	return wall;
    }
    
    public int quickselect(int []data,int k){
	return quickselect(data,k,0,data.length-1);
    }
   
    public int quickselect(int []data,int k,int left, int right){
	if (left == right){
	    return data[left];
	}
	int x= partitionOld(data,left,right);
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
    public void quickSortOld(int []data){
	quickSort(data,0,data.length-1);
    } 
    
    public void quickSortOld(int []data, int left, int right){
	if (left < right){
	    int count = partitionOld(data, left, right);
	    System.out.println("count:");
	    System.out.println(count);
	    quickSort(data,left,count);
	    quickSort(data,count+1,right);
	}
    }

    public static String name(){
	return "7,Chiu,Daniel";
    }
    private static int [] partition(int[]data, int left, int right){
	int [] temp = new int [right-left+1];
	int randomnum= left+(int)(Math.random()*((right-left)+1));
	int pivot= data[randomnum];
	int currentpos=left;
	int newArrayPosLeft=0;
	int newArrayPosRight=right-left;
	System.out.println(pivot);
	while (currentpos<=right){
	    if (data[currentpos]<pivot){
		temp[newArrayPosLeft]=data[currentpos];
		newArrayPosLeft++;
	    }
	    if (data[currentpos]>pivot){
		temp[newArrayPosRight]=data[currentpos];
		newArrayPosRight--;
	    }
	    currentpos++;
	}
	for (int x=newArrayPosLeft;x<newArrayPosRight+1; x++){
	    temp[x]=pivot;
	}
	for(int x=0;x<temp.length;x++){
	    data[left+x]=temp[x];
	}
	int[]results=new int[2];
	results[0]=newArrayPosLeft;
	results[1]=newArrayPosRight;
	return results;
    }
  
    public static void quickSort(int []data){
	quickSort(data,0,data.length-1);
    } 
    
    public static void quickSort(int []data, int left, int right){
	if (left <= right){
	    int [] count = partition(data, left, right);
	    //System.out.println(Arrays.toString(data));
	    //System.out.println(Arrays.toString(count));
	    //System.out.println("Left:");
	    //System.out.println(left);  
	    //System.out.println("Right:");
	    //System.out.println(right);
	    if (count[1] < 3){
	    	return;
	    }
	    if (count[0]-1 > 0){
		quickSort(data,left,count[0]-1);
	    }
	    if (count[1] < right-1){
		quickSort(data,count[1]+1,right);
	    }
	}
    }


    public static void main(String[]args){
	Quick test= new Quick();
	//int[]x={3,2,1,3,2,1,3,2,1};
	int[]x={8,7,6,5,4,3,2,1};
	test.quickSort(x);
	//test.partition(x,0,2);
	//test.partition(x,3,6);
	//test.partition(x,5,8);
	//System.out.println(test.partition(x,2,8));
	//System.out.println(test.quickselect(x,2));
	//test.quickselect(x,4);
	System.out.println(Arrays.toString(x));

    }

}
