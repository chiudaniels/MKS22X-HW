import java.util.*;

public class MyQueue<T>{
    private MyLinkedList <T> list;

    public MyQueue(MyLinkedList<T> x){
	list =x;
    }

    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	list.add(size(),item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	return list.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	return list.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return list.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return size()==0;
    }

     public static void main (String[]args){
	new int [] testnums= [2000];
	Queue<Integer> s= new Queue<Integer>();
	MyQueue<Integer> t= new MyQueue<Integer>();
	int test=0;
	for (x=0;x<testnums.length;x++){
	    int [x]=Math.random()*10;
	}
	for (x=0;x<testnums.length;x++){
	    s.push(testnums[x]);
	    t.push(testnums[x]);
	}
        while (!s.isEmpty()){
	    if(s.pop() != t.pop()){
		test++;
	    }
	    else{
		s.pop();
		t.pop();
	    }
	}
    }
}
