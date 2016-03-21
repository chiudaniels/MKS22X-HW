public class MyLinkedList{
    private LNode start;
    private int size;
    private LNode last;

    
    public MyLinkedList(int x, LNode y){
	size=x;
	start=y;
    }

    public int size(){
	return size;
    }

    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);
	}else{
	    LNode p = start;			
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode(value,null,p));
	    last = p.getNext();
	}
	size+=1;
	return true;
    }

    public String toString(){
	String ans = "[";
	LNode p = start;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }

    public int get(int index){
	LNode current=start;
	for (int x=0; x<index;x++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int set(int index, int newValue){
	LNode current=start;
	for (int x=0; x<index;x++){
	    current = current.getNext();
	}
	int old= current.getValue();
	current.setValue(newValue);
	return old;
    }

    public int remove(int index){
	if (index == size-1){
	    last.getPrevious().setNext(null);
	}
	LNode current=start;
	for (int x=0; x<index-1;x++){
	    current = current.getNext();
	}
	LNode previous= current;
	LNode toBeRemoved= previous.getNext();
	LNode next= toBeRemoved.getNext();
	previous.setNext(next);
	size--;
	return toBeRemoved.getValue();
    }

    public boolean add(int index,int value){
	if (index == size -1){
	    last.setNext(new LNode(value,null,last));
	    last= last.getNext();
	}
  	LNode current=start;
	for (int x=0; x<index-1;x++){
	    current = current.getNext();
	}
	LNode previous= current;
	LNode next= previous.getNext();
	previous.setNext(new LNode(value,next,last));
	size++;
	return true;
    }

    public int indexOf(int value){
	LNode current=start;
	int index=0;
	while (index<size){
	    if (current.getValue()== value){
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
