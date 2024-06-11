package Graphs.ConnectedComponents;

public class BellmanNegativeCycleDetection {

    /* Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.


Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3.
  */
    public int isNegativeWeightCycle(int V, int[][] edges)
    {
        // initialize distance
        long []distance=new long[V];
        //source distance as 0 and remaining as max value
        distance[0]=0;
        for(int i=1;i<V;i++)
        {
            distance[i]=(long)Integer.MAX_VALUE;
        }
        //relax all edges  n-1 times
        int count=V-1;
        while(count>0)
        {

            for(int i=0;i<edges.length;i++)
            {
                int source=edges[i][0];
                int dest=edges[i][1];
                int weight=edges[i][2];
                // if distance betwee source and distance is lesser then update destination distance
                if(distance[source]+weight<distance[dest])
                {
                    distance[dest]=distance[source]+weight;
                }
            }
            count--;
        }
        //relax one more time if any edge is still reducing then it have the negative edge
        for(int i=0;i<edges.length;i++)
        {
            int source=edges[i][0];
            int dest=edges[i][1];
            int weight=edges[i][2];
            if(distance[source]+weight<distance[dest])
            {
                return 1;
            }
        }

        return 0;
    }
}
