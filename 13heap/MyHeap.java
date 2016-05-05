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

   private void pushDown(int k){
   }

   private void pushUp(int k){
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
