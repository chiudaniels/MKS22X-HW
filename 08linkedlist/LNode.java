public class LNode{
    private int value;
    private LNode next;
    private LNode previous;

    public LNode(int x, LNode y, LNode z){
	value = x;
	next= y;
	previous =z;
    }

    public LNode(int x){
	value =x;
    }

    public void setNext(LNode x){
	next=x;
    }

    public void setValue(int x){
	value=x;
    }

    public int getValue(){
	return value;
    }

    public LNode getNext(){
	return next;
    }

    public void setPrevious(LNode x){
	previous = x;
    }

    public LNode getPrevious(){
	return previous;
    }
}

