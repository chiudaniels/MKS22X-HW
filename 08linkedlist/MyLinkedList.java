import java.util.*;

public class MyLinkedList<T>{
    private LNode<T> start;
    private int size;
    private LNode<T> last;

    
    public MyLinkedList(int x, LNode<T> y){
	size=x;
	start=y;
    }

    public int size(){
	return size;
    }

    public boolean add(int value){
	if(start.equal( null)){
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
	LNode<T> current=start;
	for (int x=0; x<index;x++){
	    current = current.getNext();
	}
	T old= current.getValue();
	current.setValue(newValue);
	return old;
    }

    public T remove(int index){
	int result;
	if (index== size-1){
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

    public boolean add(int index,int value){
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

    public int indexOf(int value){
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
}
