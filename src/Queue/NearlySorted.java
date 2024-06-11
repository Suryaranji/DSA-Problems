package Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {
    /*
    https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?page=3&category=Arrays&difficulty=Medium

     */
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> ans=new ArrayList<>();

        for(int it:arr){
            pq.offer(it);
            if(pq.size()>k){
                ans.add(pq.poll());
            }
        }

        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
}
