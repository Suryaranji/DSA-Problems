package Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostOfFlights {
    class Solution {
        class IndexPair {
            int dest ,cost, stop;

            IndexPair(int d, int c, int stop) {
                dest = d;
                cost = c;
                this.stop = stop;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            int best[]=new int[n];
            Arrays.fill(best,Integer.MAX_VALUE);
            Map<Integer, List<int[]>> adj=new HashMap<>();

            Queue<IndexPair> pairs=new LinkedList<>();
            for (int[] flight : flights) {
                int ts = flight[0];
                int td = flight[1];
                int cost = flight[2];
               List<int[]> list=adj.getOrDefault(ts, new ArrayList<>());
               list.add(new int[] { td, cost });
                adj.put(ts, list);

            }
            pairs.add(new IndexPair(src, 0, 0));
            best[src]=0;
            int answer=-1;
            while(!pairs.isEmpty()){
                IndexPair pair=pairs.poll();
                if(pair.stop>k)continue;
                List<int[]> list=adj.getOrDefault(pair.dest,new ArrayList<>());
                for(int[] arr:list){
                    int d=arr[0];
                    int c=arr[1];
                    if(pair.cost+c<best[d]||pair.stop<k){
                        best[d]=pair.cost+c;
                        pairs.add(new IndexPair(d,pair.cost+c,pair.stop+1));
                    }
                }
            }
            if(best[dst]!=Integer.MAX_VALUE){
                answer=best[dst];
            }
            return answer;


        }
        public int optimizedVersion(int n,int [][]flights,int src,int dst,int k){
            int best[]=new int[n];
            Arrays.fill(best,Integer.MAX_VALUE);
            Map<Integer, List<int[]>> adj=new HashMap<>();

            for (int[] flight : flights) {
                int ts = flight[0];
                int td = flight[1];
                int cost = flight[2];
                List<int[]> list=adj.getOrDefault(ts, new ArrayList<>());
                list.add(new int[] { td, cost });
                adj.put(ts, list);

            }
            PriorityQueue<IndexPair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
            pq.add(new IndexPair(src, 0, 0));
            best[src]=0;
            int answer=-1;
            while(!pq.isEmpty()){
                IndexPair pair=pq.poll();
                if(pair.dest==dst){
                    answer=pair.cost;
                    break;
                }
                if(pair.stop>k)continue;
                List<int[]> list=adj.getOrDefault(pair.dest,new ArrayList<>());
                for(int[] arr:list){
                    int d=arr[0];
                    int c=arr[1];
                    if(pair.cost+c<best[d]||pair.stop<k){
                        best[d]=pair.cost+c;
                        pq.add(new IndexPair(d,pair.cost+c,pair.stop+1));
                    }
                }
            }
            return answer;
        }
        public int optimizedVersion2(int n,int [][]flights,int src,int dst,int k){
          int[] best =new int[n];
            Arrays.fill(best,Integer.MAX_VALUE);
            best[0]=0;
            for(int i=0;i<=k;i++){
                int[] backup=Arrays.copyOf(best, n);
                for(int []fl:flights){
                    int s=fl[0];
                    int d=fl[1];
                    int c=fl[2];
                    if(backup[s]==Integer.MAX_VALUE){
                        backup[s]=c;
                    }
                    best[d]=Math.min(best[d], backup[s]+c);

                }
            }
            if(best[dst]==Integer.MAX_VALUE){
                return -1;
            }
            return best[dst];
        }


    }

    public static void main(String[] args) {

        MinimumCostOfFlights obj=new MinimumCostOfFlights();
        Solution solution=obj.new Solution();
        int n=3;
        int flights[][]={{0,1,100},{1,2,100},{0,2,500}};
        int src=0;
        int dst=2;
        int k=1;
        System.out.println(solution.optimizedVersion2(n,flights,src,dst,k));
    }
}
