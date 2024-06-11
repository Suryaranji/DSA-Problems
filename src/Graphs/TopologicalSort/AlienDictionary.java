package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    /*
   Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.


Example 1:

Input:
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is
'b', 'd', 'a', 'c' Note that words are sorted
and in the given language "baa" comes before
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input:
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
   */
    String topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
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
        String answer="";
        int index=0;
        while(!queue.isEmpty())
        {
            int vertex=queue.remove();
            answer+=(char)(vertex+'a');
            for(int i:adj.get(vertex))
            {
                indegree[i]--;
                if(indegree[i]==0)queue.add(i);
            }
        }
        return answer;
    }
    public String findOrder(String [] dict, int n, int k)
    {
        int indegree[]=new int[k];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        for(int i=0;i<k;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)
        {
            int min=Math.min(dict[i].length(),dict[i+1].length());
            //make a  graph
            for(int j=0;j<min;j++)
            {
                //if character varies then make first char is directly connected to second character
                char first=dict[i].charAt(j);
                char second=dict[i+1].charAt(j);
                if(first!=second)
                {
                    list.get((first-'a')).add((second-'a'));
                    break;
                }
            }
        }
        return topoSort(k,list);


    }
}
