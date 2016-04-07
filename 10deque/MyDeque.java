import java.util.*;

public class MyDeque<T>{
    //generic array
    public T[] data;
    public int start;
    public int end;

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
    
    public void addLast(T value){
	if ((start == 0 && end == data.length-1) || end+1 == start){
	    resize();
	}
	if (end == data.length-1){
	    data[0]=value;
	    end=0;
	}
	else{
	    data[end+1]=value;
	    end++;
	}
    }

    public void addFirst(T value){
	if ((start == 0 && end == data.length-1) || end == start-1){
	    resize();
	}
	if (start==0){
	    data[data.length-1]=value;
	    start=data.length-1;
	}
	else{
	    data[start-1]=value;
	    start--;
	}
    }

    public T removeFirst(){
	if (start==end){
	    throw new NoSuchElementException();
	}
	T result = data[start];
	data[start]=null;
	start++;
	return result;
    }

    public T removeLast(){
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

    public String toString(){
	String ans="[";
	for (int x=0;x<data.length;x++){
	    ans += data[x] +",";
	}
	return ans + "]";
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp= (T[]) new Object[data.length*2];
	int newstart =0;
	for (int x= start; x<data.length;x++){
	    temp[newstart]=data[x];
	    newstart++;
	}
	for (int y=0; y<=end;y++){
	    temp[newstart]=data[y];
	    newstart++;
	}
	start = 0;
	end = newstart;
	data=temp;
    }

    public boolean isEmpty(){
	return start == end;
    }
    
    public static void main(String[]args){
	MyDeque<String> x = new MyDeque<String>();
	x.addFirst("a");
	x.addFirst("b");
	x.addFirst("c");
	x.addFirst("d");
	x.addFirst("e");
	x.addFirst("f");
	x.addFirst("g");
	x.addFirst("h");
	x.addFirst("i");
	x.addFirst("j");
	x.addFirst("k");

	System.out.println(x.start);
	System.out.println(x.end);
	System.out.println(x);
    }
}
