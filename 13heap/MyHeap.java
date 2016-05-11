import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private int max= 1;

   public MyHeap(){
       data=(T[])new Comparable[0];
   }

   public MyHeap(T[] array){
       data=(T[])new Comparable[array.length];
       for(int x=0; x<array.length;x++){
	   data[x]=array[x];
       }
       size = array.length;
       heapify();
   }
   private void swap(int x, int y){
       T temp = data[x];
       data [x]=data[y];
       data[y]=temp;
   }

   private void pushDown(int k){
       System.out.println("index:"+k);
       System.out.println(toString());
       if (2*k+2>data.length){
	   return;
       }
       if (data[k].compareTo(data[2*k+1])*max<0 && data[2*k+1].compareTo(data[2*k+2])*max>0){
	   swap(k,2*k+1);
	   pushDown(2*k+1);
       }
       else if (data[k].compareTo(data[2*k+2])*max<0){
	   swap(k,2*k+2);
	   pushDown(2*k+2);
       }
   }

   private void pushUp(int k){
       if (k+1/2==0){
	   return;
       }
       if (data[k].compareTo(data[(k-1)/2])*max>0){
	   swap(k,(k-1)/2);
	   pushUp((k-1)/2);
       }
       else if (data[k].compareTo(data[k/2])*max>0){
	   swap(k,k/2);
	   pushUp(k/2);
       }
   }

   private void heapify(){
       for(int x=size/2;x>=0;x--){
	   pushDown(x);
       }
   }

   public T delete(){
       if (size == 0){
	   throw new NoSuchElementException(); 
       }
       T temp = data[0];
       data[0]= data[size-1];
       T [] newdata=(T[])new Comparable[size-1];
       for (int x=0; x<newdata.length;x++){
	   newdata[x]=data[x];
       }
       data=newdata;
       size--;
       pushDown(0);
       return temp;
   }

   public void add(T z){
       T [] newdata=(T[])new Comparable[size+1];
       for (int x=0; x<data.length;x++){
	   newdata[x]=data[x];
       }
       newdata[size]= z;
       data=newdata;
       pushUp(size);
       size++;
   }

   private void doubleSize(){
       T [] newdata=(T[])new Comparable[size*2];
       for (int x=0; x<data.length;x++){
	   newdata[x]=data[x];
       }
       data=newdata;
   }
   
   public T peek(){
       if (size == 0){
	   throw new NoSuchElementException(); 
       }
       return data[0];
   }

   public String toString(){
       String res="[";
       for (int x=0; x<size;x++){
	   res += data[x];
	   if (x!=size-1){
	       res +=", ";
	   }
       }
       return res + "]";
   }

   //do this last
    public MyHeap(boolean isMax){
	data=(T[])new Comparable[0];
	if (!isMax){
	    max = -1;
	}
	heapify();
    }
    public MyHeap(T[] array, boolean isMax){
	data=(T[])new Comparable[array.length];
	for(int x=0; x<array.length;x++){
	    data[x]=array[x];
	}
	size = array.length;
	if (!isMax){
	    max = -1;
	}
	heapify();
    }

}
