package Heaps.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RankTransform {
    class pair{
        int val,index;
        pair(int v,int i){
            val=v;
            index=i;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<pair> queue=new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int n=arr.length;
        for(int i=0;i<n;i++){
            queue.offer(new pair(arr[i],i));

        }
        int ans[]=new int[n];
        ans[queue.peek().index]=1;
        int rank=1,previous=queue.poll().val;

        for(int i=1;i<n;i++){
            if(queue.peek().val!=previous){
                rank++;
            }
            ans[queue.poll().index]=rank;
        }
        return ans;




    }

    public static void main(String[] args) {
        RankTransform obj=new RankTransform();
        int arr[]={40,10,20,30};
        int ans[]=obj.arrayRankTransform(arr);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
