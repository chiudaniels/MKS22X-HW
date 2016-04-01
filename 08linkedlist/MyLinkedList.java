import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> start;
    private int size;
    public LNode<T> last;

    public MyLinkedList(){
    }

    public Iterator <T> iterator(){
	return new X();
    }

    public class X implements Iterator<T>{
	LNode<T> next;
	public X(){
	    next=start;
	}
	public boolean hasNext(){
	    return next != start;
	}
	public T next(){
	    if (!hasNext()){
		throw new NoSuchElementException();
	    }
	    T value= next.getValue();
	    next = next.getNext();
	    return value;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
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
	//System.out.println("Index:" + index);
	//System.out.println("Size:"+ size);
	if (index<0 || index>size){
	    throw new IndexOutOfBoundsException();
	}
	
	if (index == size()-1){
	    //System.out.println("Hi!");
	    size--;
	    result=last.getValue();
	    last.getPrevious().setNext(null);
	    last=last.getPrevious();
	}
	
	else if (index == 0){
	    size--;
	    result= start.getValue();
	    start=start.getNext();
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
   
	if (index== size){
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
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }
	
	System.out.println(n.remove(n.size()-1));
        System.out.println(m.remove(m.size()-1));
	System.out.println(m);
	System.out.println(n);
    }
}
