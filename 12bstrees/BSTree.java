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
	public int getHeight(Node x){
	    if (left.equals(null) && right.equals(null)){
		return 1;
	    }
	    int leftsum=0;
	    int rightsum=0;
	    if (!left.equals(null)){
		leftsum += getHeight(left);
	    }
	    if (!right.equals(null)){
		rightsum += getHeight(right);
	    }
	    if (leftsum > rightsum){
		return leftsum+1;
	    }
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
