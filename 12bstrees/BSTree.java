public class BSTree<T extends Comparable<T>> {
    private class Node{
	T data;
        Node left;
	Node right;

	public Node(T value){
	    data=value;
	}
	/*
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
	*/
	public void add(T value){
	    if (data == null){
		data = value;
	    }
	    if (data.compareTo(value)<0 && left == null){
		left= new Node(value);
	    }
	    if (data.compareTo(value)>0 && right == null){
		right=new Node(value);
	    }
	    if (data.compareTo(value)<0){
		left.add(value);
	    }
	    if (data.compareTo(value)>0){
		right.add(value);
	    }
	}

	public String toString(){
	    String ans= "" + data+" ";
	    if (left == null){
		ans += "_";
	    }
	    else{
		ans += left.toString()+ " ";
	    }
	    if (right == null){
		ans +="_";
	    }
	    else{
		ans += right.toString() + " ";
	    }
	    return ans;
	}

	public boolean contains(T value){
	    boolean x=false;
	    if (!data.equals(value) && (left == null && right == null)){
		x= false;
	    }
	    if (data.equals(value)){
		x= true;
	    }
	    if(data.compareTo(value)<0){
		x= left.contains(value);
	    }
	    if(data.compareTo(value)>0){
		x= right.contains(value);
	    }
	    return x;
	}

	public int getHeight()  {
	    if (getHeight(left) > getHeight(right)){
		return getHeight(left);
	    } 
	    else{
		return getHeight(right);
	    }
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
	    else if (!right.equals(null)){
		rightsum += getHeight(right);
	    }
	    if (leftsum > rightsum){
		return leftsum+1;
	    }
	    else{
		return rightsum+1;
	    }
	}
    
    }
    private Node root;

    public void add(T value){
	if (root == null){
	    root = new Node(value);
	}
	root.add(value);
    }
    public String toString() {
	if (root == null){
	    return "";
	}
	return root.toString();
    }
    public boolean contains(T value){
        if (root == null){
	    return false;
	}
	return root.contains(value);
    }
    public int getHeight()  {
	if (root == null){
	    return 0;
	}
	return root.getHeight();
    }
}
