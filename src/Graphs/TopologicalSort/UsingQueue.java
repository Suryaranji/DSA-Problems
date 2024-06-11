package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int answer[]=new int[V];
        int indegree[]=new int[V];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            for(int j:adj.get(i))
            {
                indegree[j]++;
            }
        }
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)queue.add(i);
        }
        int index=0;
        while(!queue.isEmpty())
        {
            int vertex=queue.remove();
            answer[index++]=vertex;
            for(int i:adj.get(vertex))
            {
                indegree[i]--;
                if(indegree[i]==0)queue.add(i);
            }
        }
        return answer;
    }
}
