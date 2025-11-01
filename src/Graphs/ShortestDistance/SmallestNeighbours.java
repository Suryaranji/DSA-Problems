package Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestNeighbours {
    class Solution {
        class State{
            int dest,dist;
            State(int d,int time){
                dest=d;
                dist=time;
            }
        }
        public int bfs(List<List<int[]>> adjList,int n,int thresHold){
        //the mistake was here i was using boolean visited array but it should be int visited array to count the distance
            int[] visited =new int[adjList.size()];
            int []newAnswer=new int[adjList.size()];
            Arrays.fill(visited,Integer.MAX_VALUE);
            Queue<State> queue=new LinkedList<>();
            queue.add(new State(n,0));
            int answer=-1;
            visited[n]=0;
            while(!queue.isEmpty()){
                State state=queue.poll();
                if(newAnswer[state.dest]==0){
                    answer++;
                    newAnswer[state.dest]=1;
                }
                for(int[] adj:adjList.get(state.dest)){

                    int newDist=state.dist+adj[1];
                    if(visited[adj[0]]>newDist&&newDist<=thresHold){
                      //  System.out.println(Arrays.toString(adj));
                        visited[adj[0]]=newDist;
                        queue.add(new State(adj[0],newDist));
                    }
                }
            }
            return answer;
        }
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {

            //0->{1,3}{2,3}

            List<List<int[]>> adj=new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge:edges){
                adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
                adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
            }
            int minimum=Integer.MAX_VALUE;
            int number=0;
            for(int i=0;i<n;i++){

                int answer=bfs(adj,i,distanceThreshold);

                System.out.println(answer);
                if(answer<=minimum){
                    number=i;
                    minimum=answer;

                }

            }
            return number;


        }
    }

    public static void main(String[] args) {
        SmallestNeighbours obj=new SmallestNeighbours();
        Solution solution=obj.new Solution();
       // int[][] edges ={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};

        //[[0,1,10],[0,2,1],[2,3,1],[1,3,1],[1,4,1],[4,5,10]]
        int [][] edges={{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}};

        int n=6;
        int distanceThreshold=20;
        int ans=solution.findTheCity(n,edges,distanceThreshold);
        System.out.print(ans);
    }
}
