public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(int x, LNode y){
	size=x;
	start=y;
    }
    
    public boolean add (int value){
	if (start.getNext() == null){
	    LNode x= new LNode(value,null);
	    start.setNext(x);
	    size++;
	    return true;
	}
	return false;
    }

    public String toString(){
	String x= "[";
	x+= start.getValue();
	LNode temp=start.getNext();
	for (int count=1;count<size;count++){
	    temp = start.getNext();
	    x+="," + start.getValue();
	}
	return x+"]";
    }
}
