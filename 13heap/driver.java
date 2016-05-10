public class driver{
    public static void main(String[]args){
	Integer [] y= {4,3,2,1};
	MyHeap x = new MyHeap<Integer> (y);
	//x.heapify();
	x.add(5);
	System.out.println(x);
    } 
}
