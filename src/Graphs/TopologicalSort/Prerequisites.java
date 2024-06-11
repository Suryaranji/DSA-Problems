package Graphs.TopologicalSort;

import java.util.*;

public class Prerequisites {
    /**
     * There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
     Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.


     Example 1:

     Input:
     N = 4, P = 3
     prerequisites = {{1,0},{2,1},{3,2}}
     Output:
     Yes
     Explanation:
     To do task 1 you should have completed
     task 0, and to do task 2 you should
     have finished task 1, and to do task 3 you
     should have finished task 2. So it is possible.
     Example 2:

     Input:
     N = 2, P = 2
     prerequisites = {{1,0},{0,1}}
     Output:
     No
     Explanation:
     To do task 1 you should have completed
     task 0, and to do task 0 you should
     have finished task 1. So it is impossible.
     */
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {

        //the problem approach in reverse order but simple
        int indegree[]=new int[N];
        //map is used to store edges of each node similar to indegree
        Map<Integer,ArrayList<Integer> > map=new HashMap<>();

        // create array list for all edges or only  for prerequisites
        for(int i[]:prerequisites)
        {
            map.put(i[0],new ArrayList<>());
            //increase count of pretask because we have to finish that task priorly
            indegree[i[1]]++;

        }
        for(int i[]:prerequisites)
        {
            //add edges as usual
            map.get(i[0]).add(i[1]);

        }
        // System.out.println(map);

        Queue<Integer> queue=new LinkedList<>();
        //choos node with indegree 0
        for(int i=0;i<N;i++)
        {
            if(indegree[i]==0)queue.add(i);
        }
        //System.out.println(queue);
        //then it similar to topo sorting
        int count=0;
        while(!queue.isEmpty())
        {

            int temp=queue.remove();
            count++;
            if(map.containsKey(temp))
                for(int i:map.get(temp))
                {
                    indegree[i]--;
                    if(indegree[i]==0)queue.add(i);
                }
            if(count==N)break;
        }
        //if count==n then all nodes are visited
        return count==N;
    }
}
