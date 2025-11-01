package Heaps.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[]=new int[k];
        for(int i=k-1;i>=0;i--) {
            ans[i] = pq.poll().getKey();
        }
        return ans;

    }

    public static void main(String[] args) {
        TopKFrequentElements obj=new TopKFrequentElements();
        int arr[]={1,1,1,2,2,3};
        int k=2;
        int ans[]=obj.topKFrequent(arr,k);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
