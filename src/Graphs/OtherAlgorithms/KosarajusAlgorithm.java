package Graphs.OtherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajusAlgorithm {
    void dfs(int index, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean visited[] )
    {
        visited[index]=true;
        for(int i:adj.get(index))
        {
            if(!visited[i])
                dfs(i,adj,stack,visited);
        }
        stack.push(index);
    }
    void dfsNormal(int index,ArrayList<ArrayList<Integer>> adj,boolean visited[] )
    {
        visited[index]=true;
        for(int i:adj.get(index))
        {
            if(!visited[i])
                dfsNormal(i,adj,visited);
        }

    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //follow three steps
        //1.do normal dfs and store elements from last in stack
        // reverse graph
        // do again dfs now for every new unvisited vertes from stack consider as a stong component
        boolean vis[]=new boolean[V];
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
                dfs(i,adj,stack,vis);
        }

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<V;i++)list.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            for(int j:adj.get(i))
            {
                list.get(j).add(i);
            }
        }
        Arrays.fill(vis,false);
        int answer=0;
        while(!stack.isEmpty())
        {
            int temp=stack.pop();
            if(vis[temp]==false)
            {
                answer++;
                dfsNormal(temp,list,vis);
            }
        }
        return answer;
    }
}
