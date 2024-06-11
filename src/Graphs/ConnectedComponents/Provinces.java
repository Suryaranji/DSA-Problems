package Graphs.ConnectedComponents;

public class Provinces {
    /*
   https://leetcode.com/problems/number-of-provinces/submissions/
   */
    public void dfs(int [][] isconnected,boolean vis[],int node)
    {
        vis[node]=true;
        for(int i=0;i<isconnected.length;i++)
        {
            if(vis[i]==false&&isconnected[node][i]==1)
            {

                dfs(isconnected,vis,i);
            }

        }

    }
    public int findCircleNum(int[][] isConnected) {

        int nodes=isConnected.length;
        boolean vis[]=new boolean[nodes];
        int connected=0;
        for(int i=0;i<nodes;i++)
        {
            if(vis[i]==false)
            {
                //check each separate component if not previously visited then it is separate component
                connected++;
                dfs(isConnected,vis,i);
            }
        }
        return connected;


    }
}
