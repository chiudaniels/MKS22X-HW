public class driver{
    public static void main (String[]args){
	LNode n= new LNode(1);
	MyLinkedList x= new MyLinkedList(1,n);
	x.add(2);
	System.out.println(x.size());
	x.add(3);
	System.out.println(x.size());
	x.set(1,1);
	x.remove(2);
	x.add(2,2);
	System.out.println(x.indexOf(2));
	System.out.println(x);
	System.out.println(x.get(0));
	System.out.println(x.get(1));
	
    }
}
