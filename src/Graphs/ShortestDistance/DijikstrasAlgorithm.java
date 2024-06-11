package Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;

public class DijikstrasAlgorithm {

    /*
    Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j ,
    second integers corresponds to the weight of that  edge . You are given the source vertex S and
    You to Find the shortest distance of all the vertex's from the source vertex S.
    You have to return a list of integers denoting shortest distance between each node and Source vertex S.
    */
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int minIndex(int dist[],boolean vis[])
    {
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<dist.length;i++)
        {
            if(vis[i]==false&&dist[i]<min)
            {
                min=dist[i];
                index=i;
            }
        }
        return index;
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //dijikstra is simple
        //store distance start with source as 0

        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            //pick smallest distance index
            int minindex=minIndex(dist,vis);
            //mark as visited
            vis[minindex]=true;
            //traverse all adjacents
            for(ArrayList<Integer> list:adj.get(minindex))
            {

                int dest=list.get(0);
                int weight=list.get(1);
                //update if it have minimum distance
                if(dist[minindex]+weight<dist[dest])
                {
                    dist[dest]=dist[minindex]+weight;
                }
            }
        }
        //return distance which contains smallest from source to all other vertices
        return dist;

    }
}
