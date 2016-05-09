import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       data=new Comparable[];
       data= (T)data;
   }

   public MyHeap(T[] array){
       data=new Comparable[array.size];
       data=(T)data;
       for(int x=0; x<array.length;x++){
	   data[x]=array[x];
       }
       size = array.length;
   }
   private void swap(int x, int y){
       T temp = data[x];
       data [x]=data[y];
       data[y]=temp;
   }

    private void pushDown(int k){
	if (2*k+2>data.length){
	    return;
	}
	if (data[k].compareTo(data[2*k+1])>0){
	    swap(k,2*k);
	    pushDown(2*k);
	}
	else if (data[k].compareTo(data[2*k+2])>0){
	    swap(k,2*k+2);
	    pushDown(2*k+2);
	}
	else{
	    return
	}
    }

   private void pushUp(int k){
       if (k/2==0){
	   return;
       }
       if (data[k].compareTo(data[(k-1)/2])<0){
	   swap(k-1,(k-1)/2);
	   pushUp((k-1)/2);
       }
       else if (data[k].compareTo(data[k/2])<0){
	   swap(k,k/2);
	   pushUp(k/2);
       }
       else{
	   return;
       }
   }

   private void heapify(){
       for (int x=size/4; x<size/2;x++){
	   pushDown(x);
       }
       for(int x=size/2;x<size;x++){
	   pushUp(x);
       }
   }

   public T delete(){
       int temp = data[0];
       data[0]= data[size-1];
       T [] newdata=new Comparable[size-1];
       newdata=(T)data;
       for (int x=0; x<newdata.length;x++){
	   newdata[x]=data[x];
       }
       data=newdata;
       pushDown(0);
       return temp;
   }

   public void add(T x){
   }

   private void doubleSize(){
   }

   public String toString(){
   }

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
