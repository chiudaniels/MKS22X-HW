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
       
   }

   private void pushUp(int k){
     if (2*k+1 < array.lenth){
	   if (data[k].compareTo(data[2*k])<0){
	       swap(k,2*k);
	       pushUp(2*k);
	   }
	   if (data[k].compareTo(data[2*k+1])<0){
	       swap(k,2*k+1);
	       pushUp(2*k);
	   }
       }
   }

   private void heapify(){
   }

   public T delete(){
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
