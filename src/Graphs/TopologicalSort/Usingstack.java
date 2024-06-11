package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class Usingstack {
    static void dfs(int index,int vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack)
    {
        //mark all adjacent
        vis[index]=1;
        for(int i:adj.get(index))
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj,stack);
            }
        }
        //push last element
        stack.push(index);

    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack=new Stack<>();
        int []vis=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj,stack);
            }
        }
        //remove from top
        int answer[]=new int[V];
        int index=0;
        for(int i=0;i<V;i++)
            answer[i]=stack.pop();

        return answer;
    }
}
