import java.util.*;

public class MyStack<T>{
    private MyLinkedList <T> list;

    public MyStack(MyLinkedList<T> x){
	list =x;
    }

    /**
     * Adds the given item to the top of the stack.
     */
   public void push(T item){
	list.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	return list.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	return list.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return list.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return size()==0;
    }
}
