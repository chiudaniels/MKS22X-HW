import java.util.Arrays;

public class mergesort{
    int [] array;
    public mergesort(int [] x){
	array=x;
    }
    
    public void merge(int[]data, int starta, int enda,int startb, int endb){
	int counta=0;
	int countb=0;
	int [] temp;
	int mid=starta + (startb-starta)/2;
	temp= new int [endb-starta+1];
	if (data.length ==2){
	    if (data[0]>data[1]){
		temp[0]=data[1];
		temp[1]=data[0];
	    }
	    else{
		temp[0]=data[0];
		temp[1]=data[1];
	    }
	}
	else{
	    while (counta+starta <= enda && startb+countb <= endb){
		if (data[starta+counta]<data[startb+countb]){
		    temp[counta+countb]=data[starta+counta];
		    counta++;
		}
		if(data[startb+countb]<data[starta+counta]){
		    temp[counta+countb]=data[startb+countb];
		    countb++;
		}
		if(data[startb+countb]==data[starta+counta]){
		    temp[counta+countb]=data[starta+counta];
		    counta++;
		    temp[counta+countb]=data[startb+countb];
		    countb++;
		}

	    }
	    if (counta+starta>enda){
		while(countb+startb <= endb){
		    temp[counta+countb]= data[startb+countb];
		    countb++;
		}
	    }
	    if (countb+startb>endb){
		while(counta+starta <= enda){
		    temp[counta+countb]= data[starta+counta];
		    counta++;
		}
	    }
	}
	for (int x=0;x<temp.length;x++){
	    data[starta+x]=temp[x];
	}
    }

    public void sort(int [] data){
	if (data.length>1){
	    int mid=data.length/2;
	    merge(data,0,mid,mid+1,data.length-1);
	}
    }

    public int[] leftHalf(int [] ary){
	int length = ary.length/2;
	int [] temp= new int [length];
	for (int x=0; x<length;x++){
	    temp[x]=ary[x];
	}
	return temp;
    }

    public int[] rightHalf(int[]ary){
	int length= ary.length - (ary.length/2);
	int []temp= new int[length];
	for (int x=0; x<length;x++){
	    temp[x]= ary[(ary.length/2)+x];
	}
	return temp;
    }

    

    public static void main (String [] args){
	int[]x= {1,4,7,2,5,8};
	mergesort test=  new mergesort(x);
	test.sort(x);
	System.out.println(Arrays.toString(test.array));
    }
}
