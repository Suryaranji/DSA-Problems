package Graphs.ShortestDistance;

public class FloydWarshall {
    /*
   The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.

Example 1:

Input: matrix = {{0,25},{-1,0}}

Output: {{0,25},{-1,0}}

Explanation: The shortest distance between
every pair is already given(if it exists).
Example 2:

Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}

Output: {{0,1,7},{1,0,6},{-1,-1,0}}

Explanation: We can reach 2 from 0 as 0->1->2
and the cost will be 1+6=7 which is less than
43.
   */
    public void shortest_distance(int[][] cost)
    {
        int n=cost.length;
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    //skip current k th row and column as well as diagonals
                    if(i==j||i==k||j==k)continue;
                    //if any mid path is -1 indicates no edge hence skip current
                    if(cost[i][k]==-1||cost[k][j]==-1)continue;
                    //calculate intermediate cost
                    int tempcost=cost[i][k]+cost[k][j];
                    //if there is no edge for current path
                    //then update cost
                    if(cost[i][j]==-1)cost[i][j]=tempcost;
                        //else put minimum cost
                    else cost[i][j]=Math.min(tempcost,cost[i][j]);
                }
            }
        }
    }
}
