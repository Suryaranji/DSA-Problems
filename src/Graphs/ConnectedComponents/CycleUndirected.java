package Graphs.ConnectedComponents;

import java.util.ArrayList;

public class CycleUndirected {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean stack[], int index, int parent)
    {
        // if stack already contains current index then it has been previously visited
        if(stack[index])return true;
        // to check visited which means we already  get through this path
        if(vis[index])return false;
        // look for all adjacents
        vis[index]=true;
        stack[index]=true;
        for(Integer i:adj.get(index))
        {
            if(i!=parent&&dfs(adj,vis,stack,i,index))return true;
        }
        stack[index]=false;
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        // vis to keep track of visited nodes of entire graph

        boolean vis[]=new boolean[V];
        //stack is check if there is an cycle by revisiting the stored edjes on stack
        boolean stack[]=new boolean[V];
        // since this is an undirected graph
        //we may used to travel to all edges to check  if there exist a cycle
        for(int i=0;i<V;i++)
        {
            // if there then return true
            if(dfs(adj,vis,stack,i,i))return true;

        }
        return false;
    }
}
