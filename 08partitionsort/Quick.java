public class Quick{
    private static int partition(int[]data, int left, int right){
	int[]temp = new int[data.length];
	int randomnum= left +(int)(Math.random()*right);
	int leftcount=0;
	int rightcount=0;
	int leftpos=0;
	int rightpos=0;
	int length= temp.length-1;
	int lucky= data[randomnum];
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

    public static void main(String[]args){
	Quick test= new Quick();
	int[]x={1,9,5,7,3,2};
	System.out.println(test.partition(x,0,5));
    }
}
