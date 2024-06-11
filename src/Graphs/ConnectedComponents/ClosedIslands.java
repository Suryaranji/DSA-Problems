package Graphs.ConnectedComponents;

public class ClosedIslands {

    /*Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.
An island is a 4-directional(up,right,down and left) connected part of 1's.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.

Example 1:

Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1},
           {0, 1, 1, 1, 1, 0, 0, 1},
           {0, 1, 0, 1, 0, 0, 0, 1},
           {0, 1, 1, 1, 1, 0, 1, 0},
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1},
           {0, 1, 1, 1, 1, 0, 0, 1},
           {0, 1, 0, 1, 0, 0, 0, 1},
           {0, 1, 1, 1, 1, 0, 1, 0},
           {1, 0, 0, 0, 0, 1, 0, 1}}
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands.
Example 2:

Input:
N = 3, M = 3
mat[][] = {{1, 0, 0},
           {0, 1, 0},
           {0, 0, 1}}
Output:
1
Explanation:
mat[][] = {{1, 0, 0},
          {0, 1, 0},
          {0, 0, 1}}
There is just a one closed island.
    */
    public boolean dfs(int[][] matrix,int[][] vis,int row,int col)
    {
        //check only for four directions
        int [][]dir={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        vis[row][col]=1;
        boolean flag=true;
        for(int i=0;i<dir.length;i++)
        {
            int newrow=row+dir[i][0];
            int newcol=col+dir[i][1];
            //if sides reached end then it suggest it is not a island
            //but we want make sure all of its adjacet land as well
            if(newrow<0||newrow>=matrix.length||newcol<0||newcol>=matrix[0].length)
            {
                flag= false;
                continue;
            }
            //d dfs for all unvisited nodes
            if(vis[newrow][newcol]==0&&matrix[newrow][newcol]==1)
            {
                if(!dfs(matrix,vis,newrow,newcol)) flag=false;

            }

        }
        return flag;
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        /*
        this is simpler but bit tricky
        same as number of island where we connect boundary as water
        but here we consider that as land
        */
        int visitedmatrix[][]=new int[N][M];
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(visitedmatrix[i][j]==0&&matrix[i][j]==1&&dfs(matrix,visitedmatrix,i,j))
                {

                    count++;

                }
            }
        }


        return count;
    }
}
