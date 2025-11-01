package Heaps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeapOperations {

    public static void main(String[] args) {
        Heap minHeap=new MinHeap();
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(1);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(0);
        minHeap.delete();
        minHeap.delete();
        minHeap.delete();
        minHeap.delete();
        minHeap.delete();
        minHeap.delete();
/*



       ;*/
        System.out.println(minHeap.getAllElements());
        HeapOperations heapOperations=new HeapOperations();
         printTree(minHeap.getAllElements(),0,0);
        System.out.println(minHeap.getFirst());
    }
    public static void printTree(List<Integer> elements,int index,int level){
        if(index>=elements.size())
            return;

        //go to right last
        printTree(elements,2*index+2,level+1);
        printSpaces(level);
        System.out.println(elements.get(index));
        printTree(elements,2*index+1,level+1);



    }
    public static void printSpaces(int count){
        for(int i=0;i<count;i++)
            System.out.print("    ");
    }

}
