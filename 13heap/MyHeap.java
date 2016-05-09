import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean max;

   public MyHeap(){
       data=(T[])new Comparable[0];
       max=true;
   }

   public MyHeap(T[] array){
       data=(T[])new Comparable[array.length];
       for(int x=0; x<array.length;x++){
	   data[x]=array[x];
       }
       size = array.length;
       max=true;
   }
   private void swap(int x, int y){
       T temp = data[x];
       data [x]=data[y];
       data[y]=temp;
   }

    private void pushDown(int k){
	if (max==false){
	    if (2*k+2>data.length){
		return;
	    }
	    if (data[k].compareTo(data[2*k+1])<0){
		swap(k,2*k);
		pushDown(2*k);
	    }
	    else if (data[k].compareTo(data[2*k+2])<0){
		swap(k,2*k+2);
		pushDown(2*k+2);
	    }
	    else{
		return;
	    }
	}
	else{
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
		return;
	    }
	}
    }

   private void pushUp(int k){
       if (max==false){
	   if (k/2==0){
	       return;
	   }
	   if (data[k].compareTo(data[(k-1)/2])>0){
	       swap(k-1,(k-1)/2);
	       pushUp((k-1)/2);
	   }
	   else if (data[k].compareTo(data[k/2])>0){
	       swap(k,k/2);
	       pushUp(k/2);
	   }
	   else{
	       return;
	   }
       }
       else{
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
       newdata[size+1]= z;
       data=newdata;
       pushUp(size-1);
   }

   private void doubleSize(){
       T [] newdata=(T[])new Comparable[size*2];
       for (int x=0; x<data.length;x++){
	   newdata[x]=data[x];
       }
       data=newdata;
   }

   public String toString(){
       String res="[";
       for (int x=0; x<size;x++){
	   res += data[x];
	   if (x!=size-1){
	       res +=", ";
	   }
       }
       return res;
   }

   //do this last
    public MyHeap(boolean isMax){
	data=(T[])new Comparable[0];
	max = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	data=(T[])new Comparable[array.length];
	for(int x=0; x<array.length;x++){
	    data[x]=array[x];
	}
	size = array.length;
	max=isMax;
    }

}
