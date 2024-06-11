package Graphs.ConnectedComponents;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
       /*
    Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


    */

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean stack[], int index)
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
            if(dfs(adj,vis,stack,i))return true;
        }
        stack[index]=false;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {


        // vis to keep track of visited nodes of entire graph

        boolean vis[]=new boolean[V];
        //stack is check if there is an cycle by revisiting the stored edjes on stack
        boolean stack[]=new boolean[V];
        // since this is an undirected graph
        //we may used to travel to all edges to check  if there exist a cycle
        for(int i=0;i<V;i++)
        {
            // if there then return true
            if(dfs(adj,vis,stack,i))return true;

        }
        return false;


    }
    public boolean isCyclicTopological(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree
                = new int[V]; // stores in-degree of each vertex
        Queue<Integer> q
                = new LinkedList<>(); // queue to store vertices
        // with 0 in-degree
        int visited = 0; // count of visited vertices

        // calculate in-degree of each vertex
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // enqueue vertices with 0 in-degree
        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.add(u);
            }
        }

        // BFS traversal
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            // reduce in-degree of adjacent vertices
            for (int v : adj.get(u)) {
                inDegree[v]--;
                // if in-degree becomes 0, enqueue the
                // vertex
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return visited != V; // if not all vertices are
        // visited, there is a cycle
    }
}
