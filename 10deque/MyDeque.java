import java.util.*;

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
    
    private void addLast(T value){
	if ((start == 0 && end == data.length-1) || end+1 == start){
	    resize();
	}
	if (end == data.length-1){
	    data[0]=value;
	    end=0;
	}
	data[end+1]=value;
	end++;
    }

    private void addFirst(T value){
	if ((start == 0 && end == data.length-1) || end == start-1){
	    resize();
	}
	if (start==0){
	    data[data.length-1]=value;
	    start=data.length-1;
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
	T result = data[end];
	data[end]=null;
	end--;
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
	return data[end];
    }

    private void resize(){
	T[] temp= (T[]) new Object[data.length*2];
	int newstart =0;
	for (int x= start; x<data.length-1;x++){
	    temp[newstart]=data[x];
	    newstart++;
	}
	for (int y=0; y<=end;y++){
	    temp[newstart]=data[y];
	    newstart++;
	}
	data=temp;
    }
    
    public static void main(String[]args){
	MyDeque<String> x = new MyDeque<String>();
	x.add("fish");
	System.out.println(x.get());
    }
}
