import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> start;
    private int size;
    private LNode<T> last;

    public MyLinkedList(){
    }

    public Iterator<T> iterable(){
	return new X();
    }

    public class X implements Iterator<T>{
	LNodes<T> current;
	public boolean hasNext(){
	}
	    
    }
    
    public MyLinkedList(LNode<T> y){
	size=1;
	start=y;
    }

    public int size(){
	return size;
    }

    public boolean add(T value){
	if(start==null){
	    start = new LNode<T>(value);
	}else{
	    LNode<T> p = start;			
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode<T>(value,null,p));
	    last = p.getNext();
	}
	size+=1;
	return true;
    }

    public String toString(){
	String ans = "[";
	LNode<T> p = start;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }

    public T get(int index){
	LNode<T> current=start;
	for (int x=0; x<index;x++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public T set(int index, T newValue){
	if (index<0 || index>size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current=start;
	for (int x=0; x<index;x++){
	    current = current.getNext();
	}
	T old= current.getValue();
	current.setValue(newValue);
	return old;
    }

    public T remove(int index){
	T result;
	if (index<0 || index>size){
	    throw new IndexOutOfBoundsException();
	}
	if (index== size){
	    result=last.getValue();
	    last.getPrevious().setNext(null);
	    last=last.getPrevious();
	}
	else{
	    LNode<T> current=start;
	    for (int x=0; x<index-1;x++){
		current = current.getNext();
	    }
	    LNode<T> previous= current;
	    LNode<T> toBeRemoved= previous.getNext();
	    LNode<T> next= toBeRemoved.getNext();
	    previous.setNext(next);
	    size--;
	    result= toBeRemoved.getValue();
	}
	return result;
    }

    public boolean add(int index,T value){
	if (index<0 || index>size){
	    return false;
	}
   
	if (index== size -1){
	    last.setNext(new LNode<T>(value,null,last));
	    last= last.getNext();
	}
	else{
	    LNode<T> current=start;
	    for (int x=0; x<index-1;x++){
		current = current.getNext();
	    }
	    LNode<T> previous= current;
	    LNode<T> next= previous.getNext();
	    previous.setNext(new LNode<T>(value,next,last));
	    size++;
	}
	return true;
    }

    public int indexOf(T value){
	LNode<T> current=start;
	int index=0;
	while (index<size){
	    if (current.getValue().equals(value)){
		return index;
	    }
	    else{
		current = current.getNext();
		index++;
	    }
	}
	return -1;
    }

    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();
	m.add("Hi");
    }
}
