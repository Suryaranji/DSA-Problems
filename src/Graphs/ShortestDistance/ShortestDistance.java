package Graphs.ShortestDistance;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistance {
    /*
     Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which the total cost incurred is minimum.
 From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).

 Note: It is assumed that negative cost cycles do not exist in the input matrix.


 Example 1:

 Input: grid = {{9,4,9,9},{6,7,6,4},
 {8,3,3,7},{7,4,9,10}}
 Output: 43
 Explanation: The grid is-
 9 4 9 9
 6 7 6 4
 8 3 3 7
 7 4 9 10
 The minimum cost is-
 9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
 Example 2:

 Input: grid = {{4,4},{3,7}}
 Output: 14
 Explanation: The grid is-
 4 4
 3 7
 The minimum cost is- 4 + 3 + 7 = 14.
     */
    class Pair{
        int row,col,cost;
        Pair(int r,int c,int d)
        {
            row=r;
            col=c;
            cost=d;
        }


    }
    public int minimumCostPath(int[][] grid)
    {
        int n=grid.length;
        int min[][]=new int[n][n];
        int dir[][]={
                {0,-1},
                {-1,0},
                {1,0},
                {0,1}
        };
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                min[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>((p1, p2) -> Integer.compare(p1.cost,p2.cost));;
        //HashSet<Pair> set=new HashSet<>();
        queue.add(new Pair(0,0,grid[0][0]));
        min[0][0]=grid[0][0];
        while(!queue.isEmpty())
        {

            Pair temp=queue.remove();
            //set.remove(temp);
            for(int i=0;i<4;i++)
            {
                // pick elaement and look for all adjacents
                int newx=temp.row+dir[i][0];
                int newy=temp.col+dir[i][1];
                if(newx>=0&&newy>=0&&newx<n&&newy<n)
                {
                    if(min[newx][newy]>min[temp.row][temp.col]+grid[newx][newy])
                    {
                        //update when it is smaller
                        if(min[newx][newy]!=Integer.MAX_VALUE)
                        {
                            queue.remove(new Pair(newx,newy,min[newx][newy]));
                        }

                        min[newx][newy]=min[temp.row][temp.col]+grid[newx][newy];
                        queue.add(new Pair(newx,newy,min[newx][newy]));




                    }
                }
            }

        }

        return min[n-1][n-1];
    }

    public static void main(String[] args) {
        ShortestDistance shortestDistance=new ShortestDistance();
        System.out.println(shortestDistance.minimumCostPath(new int[][]{
                {9 ,4 ,9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}
                }));
    }
}
