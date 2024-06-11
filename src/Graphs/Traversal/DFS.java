package Graphs.Traversal;

import java.util.ArrayList;

public class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int v,ArrayList<Integer> answer,int index,boolean vis[])
    {
        // add new nodes as it comes
        answer.add(index);

        for(int i=0;i<adj.get(index).size();i++)
        {
            // pick adjacent node
            int node=adj.get(index).get(i);
            // if not visited explore that node and mark as visited
            if(!vis[node])
            {
                vis[node]=true;
                dfs(adj,v,answer,node,vis);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> answer=new ArrayList<>();
        boolean []vis=new boolean[V];
        vis[0]=true;
        dfs(adj,V,answer,0,vis);
        return answer;

    }
}
