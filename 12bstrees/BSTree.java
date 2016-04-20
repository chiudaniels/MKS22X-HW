public class BSTree<T extends comparable<T>> {
    private class Node{
	T data;
        Node left;
	Node right;
	public void setValue(T value){
	    data= value;
	}
	public void setLeft(Node value){
	    left= value;
	}
	public void setRight(Node value){
	    right= value;
	}
	public T getValue(){
	    return data;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}
	public void add(T value){
	}
	public String toString() {
	}
	public boolean contains(T value){
	}
	public int getHeight()  {
	}
    
    }
    Node root;

    public void add(T value){
    }
    public String toString() {
    }
    public boolean contains(T value){
    }
    public int getHeight()  {
    }
   
}
