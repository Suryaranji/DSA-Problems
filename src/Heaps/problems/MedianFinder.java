package Heaps.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
    //to store larger elements in minheap
    PriorityQueue<Integer> minHeap;
    //to store smaller elements in maxheap
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);


    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()||num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        //balance the heaps
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else{

            return (maxHeap.peek()+minHeap.peek())/2.0;
        }


    }

    public static void main(String[] args) {
        MedianFinder obj=new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
