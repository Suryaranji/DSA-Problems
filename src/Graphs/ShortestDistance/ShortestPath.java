package Graphs.ShortestDistance;

import java.util.Arrays;

public class ShortestPath {
    /*
    Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Example1:

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2.
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.
    */
    public int[] shortestPath(int N,int M, int[][] edges) {

        int distance[]=new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        int count=N-1;
        //relax distance arry n-1 times
        while(count>0)
        {
            for(int i=0;i<edges.length;i++)
            {
                int s=edges[i][0];
                int t=edges[i][1];
                int w=edges[i][2];
                if((long)distance[s]+(long)w<(long)distance[t])
                {
                    distance[t]=distance[s]+w;
                }
            }
            count--;
        }
        //if any max value then there is no path hence insert -1
        for(int i=0;i<N;i++)
        {
            if(distance[i]==Integer.MAX_VALUE)distance[i]=-1;
        }
        return distance;


    }
}
