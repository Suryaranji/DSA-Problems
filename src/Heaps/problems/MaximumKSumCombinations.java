package Heaps.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumKSumCombinations {
    class Solution {

        class Pair{
            int i,j,sum;
            Pair(int i,int j ,int sum){
                this.i=i;
                this.j=j;
                this.sum=sum;
            }
        }
        public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
            // code here
            int n=a.length;
            PriorityQueue<Pair> pq=new PriorityQueue<>((i,j)->j.sum-i.sum);
            Arrays.sort(a);
            Arrays.sort(b);
            pq.add(new Pair(n-1,n-1,a[n-1]+b[n-1]));
            ArrayList<Integer> result=new ArrayList<>();
            Set<String> set=new HashSet<>();
            set.add((n-1)+"-"+(n-1));
            while(!pq.isEmpty()&&result.size()<k){
                Pair pair=pq.poll();
                result.add(pair.sum);
                if(pair.i-1>=0&&!set.contains((pair.i-1)+"-"+(pair.j))){
                    set.add((pair.i-1)+"-"+(pair.j));
                    pq.offer(new Pair(pair.i-1,pair.j,a[pair.i-1]+b[pair.j]));
                }
                if(pair.j-1>=0&& !set.contains((pair.i)+"-"+(pair.j-1))){
                    set.add((pair.i)+"-"+(pair.j-1));
                    pq.offer(new Pair(pair.i,pair.j-1,a[pair.i]+b[pair.j-1]));
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        MaximumKSumCombinations obj=new MaximumKSumCombinations();
        int a[]={10,9,5,3,7};
        int b[]={6,6,3,2,2};
        int k=5;
        ArrayList<Integer> ans=obj.new Solution().topKSumPairs(a,b,k);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
