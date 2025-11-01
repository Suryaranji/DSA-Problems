package Heaps.problems;

import java.util.PriorityQueue;

public class KthLargestInString {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            int aLen=a.length();
            int bLen=b.length();
            if(aLen==bLen){
                return a.compareTo(b);
            }
            return aLen-bLen;

        });
        for(String i:nums){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
