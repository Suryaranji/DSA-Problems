package Graphs.Multisource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    /*
   Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.


Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
   */
    //Function to find minimum time required to rot all oranges.
/*    public void dfs(int[][] matrix,int[][] vis,int row,int col,int time)
    {
        //check only for four directions
        int [][]dir={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        if(vis[row][col]==0)vis[row][col]=time;
        else
        {
            if(vis[row][col]<time)return;
            vis[row][col]=time;
        }
        for(int i=0;i<dir.length;i++)
        {
            int newrow=row+dir[i][0];
            int newcol=col+dir[i][1];
            //if sides reached end then it suggest it is not a island
            //but we want make sure all of its adjacet land as well
            if(newrow<0||newrow>=matrix.length||newcol<0||newcol>=matrix[0].length)
            {
                continue;
            }
            if(matrix[newrow][newcol]==1)
                dfs(matrix,vis,newrow,newcol,time+1);


        }

    }
    public int orangesRotting(int[][] matrix)
    {
        //this is a brute force approach where you reach all vertex and do dfs if you again encounter same update with miniumu time
        int N=matrix.length;
        int M=matrix[0].length;
        int visitedmatrix[][]=new int[N][M];
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(matrix[i][j]==2)
                {
                    dfs(matrix,visitedmatrix,i,j,0);
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(matrix[i][j]==1&&visitedmatrix[i][j]==0)return -1;
                count=Math.max(visitedmatrix[i][j],count);
            }
        }
        return count;
    }*/
    class Solution
    {
        //Function to find minimum time required to rot all oranges.
        public int orangesRotting(int[][] grid)
        {
            int ct = 0, res = -1;

            //queue to store cells which have rotten oranges.
            Queue<ArrayList<Integer>> q = new LinkedList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            //traversing over all the cells of the matrix.
            for(int i=0; i<grid.length; i++)
            {
                for(int j=0; j<grid[0].length; j++)
                {
                    //if grid value is more than 0, we increment the counter.
                    if(grid[i][j]>0)
                        ct++;
                    //if grid value is 2, we push the cell indexes into queue.
                    if(grid[i][j]==2)
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        q.add(temp);
                    }
                }
            }

            while(!q.isEmpty())
            {
                //incrementing result counter.
                res++;
                int size = q.size();
                for(int k=0; k<size; k++)
                {
                    //popping the front element of queue and storing cell indexes.
                    ArrayList<Integer> cur=q.poll();
                    ct--;

                    //traversing the adjacent vertices.
                    for(int i=0; i<4; i++)
                    {
                        int x=cur.get(0)+dx[i], y=cur.get(1)+dy[i];

                        //if cell indexes are within matrix bounds and grid value
                        //is not 1, we continue the loop else we store 2 in current
                        //cell and push the cell indexes in the queue.
                        if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]!=1)
                            continue;
                        grid[x][y]=2;
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(x);
                        temp.add(y);
                        q.add(temp);
                    }
                }
            }
            //returning the minimum time.
            if(ct==0)
                return Math.max(0, res);
            return -1;
        }
    }
}
