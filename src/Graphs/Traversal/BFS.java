package Graphs.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /*
  Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:
V = 5, E = 4
adj = {{1,2,3},{},{4},{},{}}


Output:
0 1 2 3 4
Explanation:
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3. After this 2 to 4, thus bfs will be
0 1 2 3 4.
  */
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //create arraylist to store answers
        ArrayList<Integer> answer=new ArrayList<>();
        //to store visited array
        int visited[]=new int[V];
        Queue<Integer> queue=new LinkedList<>();
        //add source node
        queue.add(0);
        // ark visited
        visited[0]=1;

        while(!queue.isEmpty())
        {
            // remove first element from queue
            int node=queue.remove();
            //add to answer list
            answer.add(node);


            for(int i=0;i<adj.get(node).size();i++)
            {
                // System.out.println(i);
                // find all adjacents and check if they are already visited if not mark and add in queue
                int adjacent=adj.get(node).get(i);
                if(visited[adjacent]==0)
                {
                    visited[adjacent]=1;

                    queue.add(adjacent);
                }
            }

        }
        return answer;
    }
}
