public class LNode{
    private int value;
    private LNode next;

    public LNode(int x, LNode y){
	value = x;
	next= y; 
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
}

