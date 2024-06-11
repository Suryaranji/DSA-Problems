package Recursion;

public class MColoringGraph {
    /*
    Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
     */

    // function to check valid colour or not
    public boolean isPossible(boolean graph[][],int colorArray[],int color,int node)
    {
        for(int i=0;i<graph.length;i++)
        {
            if((graph[node][i]||graph[i][node])&&colorArray[i]==color)return false;

        }
        return true;
    }

    public boolean color(boolean graph[][], int m, int n,int colorArray[],int node)
    {
        if(node==n)
        {
            return true;
        }
        //check for each colours
        for(int i=1;i<=m;i++)
        {
            //possiblity of a new colour
            if(isPossible(graph,colorArray,i,node))
            {
                colorArray[node]=i;
                // check for next node if posible the  return true
                if(color(graph,m,n,colorArray,node+1))return true;
                colorArray[node]=0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        //colours for each node
        int colorArray[]=new int[n];
        return color(graph,m,n,colorArray,0);



    }
}
