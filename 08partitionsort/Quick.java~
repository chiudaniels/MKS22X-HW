import java.util.Arrays;

public class Quick{
    private static int partition(int[]data, int left, int right){
	int[]temp = new int[data.length];
	int randomnum= (int)(Math.random()*(right-left+1));
	int leftcount=0;
	int rightcount=0;
	int leftpos=0;
	int rightpos=0;
	int length= temp.length-1;
	int lucky= data[randomnum];
	System.out.println(lucky);
	System.out.println(left);
	System.out.println(right);
	while (leftcount+rightcount<length){
	    if (data[lucky]>data[leftcount]){
		    temp[leftcount]=data[leftpos];
		    leftcount++;
		    leftpos++;
	    }
	    else if (data[lucky]<data[leftcount]){
		    temp[leftcount]=data[length-rightpos];
		    leftcount++;
		    rightpos++;
	    }
	    if (data[lucky]>data[length-rightcount]){
		temp[length-rightcount]=data[leftpos];
		rightcount++;
		leftpos++;
	    }
	    else if (data[lucky]<data[length-rightcount]){
		temp[length-rightcount]=data[length-rightpos];
		rightcount++;
		rightpos++;
	    }
	}
	temp[leftpos]=data[randomnum];
	data=temp;
	return leftpos-1;
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
	System.out.println(test.partition(x,0,5));
	System.out.println(Arrays.toString(x));
    }

}
