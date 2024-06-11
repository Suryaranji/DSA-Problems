package Graphs.ConnectedComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TarjansAlgorithmSCC {
    /*
   Given a Directed Graph with V vertices and E edges, Find the members of strongly connected components in the graph.

Note - Sort both the individual components and array of the components.

Example 1:

Input:

Output:
0 1 2,3,4,
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph as mentioned
in the Output.*/
    //Function to return a list of lists of integers denoting the members
    //of strongly connected components in the given graph.
    int time=0;
    public void dfs(ArrayList<ArrayList<Integer>>answer, ArrayList<ArrayList<Integer>> adj,boolean stack[],Stack<Integer> components,int disc[],int low[],int index)
    {
        //mark node as visited
        stack[index]=true;
        time++;
        //update lowtime and discovery time since we dont know about feature nodes
        // we keep low as same time as well
        //discovery time same
        disc[index]=time;
        low[index]=time;

        components.push(index);
        //traverse all corresponding neighbours
        for(int i:adj.get(index))
        {
            //if(i==index)continue;
            // if unvisited do dfs
            if(disc[i]==-1)
            {
                //System.out.println(index+"->"+i);
                dfs(answer,adj,stack,components,disc,low,i);
                // if next node low is smaller which indicates it has found smallest link then update its also
                low[index]=Math.min(low[index],low[i]);
            }
            else if(stack[i])
            {
                //System.out.println("In stack  "+index+"->"+i);
                //if it is in stack then it is a back edge
                // then uodate discovery time with low link
                low[index]=Math.min(low[index],disc[i]);
            }
        }
        //if both are equal then it is strongly connected component
        if(disc[index]==low[index])
        {
            //pop stack until it reaches corresponding index
            //System.out.println(index);
            ArrayList<Integer> ans=new ArrayList<>();
            while(components.peek()!=index)
            {
                //mark those component as unvisited
                stack[components.peek()]=false;
                ans.add(components.pop());
            }
            stack[components.peek()]=false;
            ans.add(components.pop());
            Collections.sort(ans);

            //add to answer
            answer.add(ans);
        }

    }
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // to find scc
        //discovery time
        int disc[]=new int[V];
        //lowest node accesible from that node
        int low[]=new int[V];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        ArrayList<ArrayList<Integer>>answer=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(disc[i]==-1)
            {
                dfs(answer,adj,new boolean[V],new Stack<>(),disc,low,i);
            }
        }
        Collections.sort(answer,(a, b)->a.get(0)-b.get(0));

        return answer;

    }
}
