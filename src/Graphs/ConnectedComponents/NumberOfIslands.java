package Graphs.ConnectedComponents;

public class NumberOfIslands {
    /*
   Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or boundary of grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0
There are two islands :- one is colored in blue
and other in orange.
   */
    public boolean isIsland(char[][]grid,int row,int col)
    {
        int dir[][]={
                {0,-1},
                {1,-1},
                {1,0},
                {1,1},
                {0,1},
                {-1,1},
                {-1,0},
                {-1,-1}};
        grid[row][col]='0';
        for(int i=0;i<dir.length;i++)
        {

            int x1=row+dir[i][0],y=col+dir[i][1];
            if(x1>=0&&x1<grid.length&&y>=0&&y<grid[0].length&&grid[x1][y]=='1')
            {
                //do dfs for all reachable vertices

                isIsland(grid,x1,y);

            }
        }
        return true;
    }
    public int numIslands(char[][] grid) {
        //dont want to make changes in original array then make use of extra space to mark visited list
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            //keep track of each cell
            for(int j=0;j<grid[i].length;j++)
            {
                //do dfs to visit each node and mark visited which indicates we dont visit again ad check all eight directions
                if(grid[i][j]=='1'&&isIsland(grid,i,j))count++;
            }
        }
        return count;
    }
}
