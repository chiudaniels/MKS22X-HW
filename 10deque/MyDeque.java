public class MyDeque<T>{
    //generic array
    T[] data;
    int start;
    int end;

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public MyDeque(){
	//typecast object array to generic array
	data = (T[]) new Object[10];
    }
    
    public void add(T n){
	data[0]=n;
    }

    public T get(){
	return data[0];
    }
    
    private addLast(T value){
	if ((start == 0 && end == data.size-1) || end+1 == start){
	    resize();
	}
	if (end == data.size-1){
	    data[0]=value;
	    end=0;
	}
	data[end+1]=value;
	end++;
    }

    private addFirst(T value){
	if ((start == 0 && end == data.size-1) || end == start-1){
	    resize();
	}
	if (start==0){
	    data[data.size-1]=value;
	    start=data.size-1;
	}
	data[start-1]=value;
	start--;
    }

    private T removeFirst(){
	if (start==end){
	    throw new NoSuchElementException();
	}
	T result = data[start];
	data[start]=null;
	start++;
	return result;
    }

    private T removeLast(){
	if (start==end){
	    throw new NoSuchElementException();
	}
	T result = data[last];
	data[last]=null;
	last--;
	return result;
    }

    public T getFirst(){
	if (start==end){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if (start==end){
	    throw new NoSuchElementException();
	}
	return data[last];
    }

    private void resize(){
	temp= (T[]) new Object[data.size*2];
	int newstart =0;
	for (int x= start; x<data.size-1;x++){
	    temp[newstart]=data[x];
	    newstart++;
	}
	for (int y=0; t<=end;y++){
	    temp[newstart]=data[y];
	    newstart++;
	}
	date=temp;
    }
    
    public static void main(String[]args){
	Tester<String> x = new Tester<String>();
	x.add("fish");
	System.out.println(x.get());
    }
}
}