public class LNode <T>{
    private T value;
    private LNode<T> next;
    private LNode<T> previous;

    public LNode(T x, LNode y, LNode z){
	value = x;
	next= y;
	previous =z;
    }

    public LNode(T x){
	value =x;
    }

    public void setNext(LNode<T> x){
	next=x;
    }

    public void setValue(T x){
	value=x;
    }

    public T getValue(){
	return value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setPrevious(LNode<T> x){
	previous = x;
    }

    public LNode<T> getPrevious(){
	return previous;
    }
}

