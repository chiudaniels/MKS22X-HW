import java.util.*;
public class FrontierQueue<T> implements Frontier <T>{
    private MyQueue<T> frontier;

    public void add(T element){
	frontier.enqueue(element);
    }
    public T next(){
	return frontier.peek();
    }
    public boolean hasNext(){
	return frontier.peek() == null;
    }
}

