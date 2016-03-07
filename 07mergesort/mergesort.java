public class mergesort{
    public int [] data;
    public mergesort(int[]array){
	data = array;
    }
    
    public void merge(int starta, int enda,int startb, int endb){
	int counta=0;
	int countb=0;
	int [] temp;
	temp= new int [endb-starta+1];
	while (counta+starta <= enda || startb+countb <= endb){
	    if (data[starta+counta]>data[startb+countb]){
		temp[counta+countb]=data[starta+counta];
		counta++;
	    }
	    if(data[startb+countb]>data[starta+counta]){
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
		temp[counta+countb-1]= data[startb+countb];
		countb++;
	    }
	}
	if (countb+startb>endb){
	    while(counta+starta <= enda){
		temp[counta+countb-1]= data[starta+counta];
		counta++;
	    }
	}
	for (int x=0;x<temp.length;x++){
	    data[starta+x]=temp[x];
	}
    }
}
