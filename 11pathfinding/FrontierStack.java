import java.util.*;
public class FrontierStack<T> implements Frontier <T>{
    private Stack<T> frontier;

    public void add(T element){
	frontier.push(element);
    }
    public T next(){
	return frontier.pop();
    }

    public T peek(){
	return frontier.peek();
    }
    
    public boolean hasNext(){
	return frontier.peek() == null;
    }
}
