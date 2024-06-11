package Graphs.Bipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    /**
     * Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

     Know more about Bipartite Graph: - https://www.geeksforgeeks.org/what-is-bipartite-graph/

     Example 1:

     Input:

     Output: 1
     Explanation: The given graph can be colored
     in two colors so, it is a bipartite graph.
     */
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int vertices[]=new int[V];
        Arrays.fill(vertices,-1);
        //traverse all vertices
        for(int j=0;j<V;j++)
        {
            //if not colored
            if(vertices[j]==-1)
            {
                //color particular vertex
                Queue<Integer> queue=new LinkedList<>();
                queue.add(j);
                vertices[j]=1;
                while(!queue.isEmpty())
                {
                    int node=queue.remove();
                    int color=vertices[node];
                    //color adjacent
                    for(int i:adj.get(node))
                    {
                        //new vertex color opposite
                        if(vertices[i]==-1)
                        {
                            queue.add(i);
                            vertices[i]=1-color;
                        }
                        //else check for same color of parent if so  return fase 
                        else if(vertices[i]==color)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
