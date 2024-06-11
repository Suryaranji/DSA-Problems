package Graphs.TopologicalSort;

import java.util.*;

public class CourseSheduleI {
    /*
   There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisite tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. Driver code will print "No Ordering Possible", on returning an empty array. Returning any correct order will give the output as 1, whereas any invalid order will give the output 0.

Example 1:

Input:
n = 2, m = 1
prerequisites = {{1, 0}}
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output would be 1 for all test cases. One possible order is [0, 1].
Example 2:

Input:
n = 4, m = 4
prerequisites = {{1, 0},
              {2, 0},
              {3, 1},
              {3, 2}}
Output:
1
Explanation:
There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3]. Returning any of these order will result in an output of 1.
   */
    static int[] findOrder(int N, int m, ArrayList<ArrayList<Integer>> prerequisites)
    {
        //the problem approach in reverse order but simple
        int indegree[]=new int[N];
        //map is used to store edges of each node similar to indegree
        Map<Integer,ArrayList<Integer> > map=new HashMap<>();

        // create array list for all edges or only  for prerequisites
        for(ArrayList<Integer> i:prerequisites)
        {
            map.put(i.get(0),new ArrayList<>());
            //increase count of pretask because we have to finish that task priorly
            indegree[i.get(1)]++;

        }

        for(ArrayList<Integer> i:prerequisites)
        {
            map.get(i.get(0)).add(i.get(1));

        }
        // System.out.println(map);

        Queue<Integer> queue=new LinkedList<>();
        int answer[]=new int[N];
        //choos node with indegree 0
        for(int i=0;i<N;i++)
        {
            if(indegree[i]==0)queue.add(i);
        }
        //System.out.println(queue);
        //then it similar to topo sorting
        int count=N-1;
        while(!queue.isEmpty())
        {

            int temp=queue.remove();
            answer[count--]=temp;
            if(map.containsKey(temp))
                for(int i:map.get(temp))
                {
                    indegree[i]--;
                    if(indegree[i]==0)queue.add(i);
                }


        }
        //to check whether all task are able to be finished
        if(count==-1)return answer;
        //System.out.println(Arrays.toString(answer)+" "+count);
        return new int[]{};

    }
}
