package Graphs.ConnectedComponents;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIsland {
    /*
  Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
          {1, 1, 0, 0, 0},
          {0, 0, 0, 1, 1},
          {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0},
          {1, 1, 0, 0, 0},
          {0, 0, 0, 1, 1},
          {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we
have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
          {1, 0, 0, 0, 0},
          {0, 0, 0, 0, 1},
          {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1},
          {1, 0, 0, 0, 0},
          {0, 0, 0, 0, 1},
          {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

  */
    public boolean isIsland(int [][]grid, int row, int col, List<List<Integer>> pair, int bx, int by)
    {

        //look for only four directions
        int dir[][]={
                {0,-1},
                {1,0},
                {0,1},
                {-1,0}};
        grid[row][col]=-1;
        // store coordinates x and y from base to identify corresponding pattern available
        List<Integer> temp=new ArrayList<>();
        temp.add(row-bx);
        temp.add(col-by);
        pair.add(new ArrayList<>(temp));
        for(int i=0;i<dir.length;i++)
        {

            int x1=row+dir[i][0],y=col+dir[i][1];
            if(x1>=0&&x1<grid.length&&y>=0&&y<grid[0].length&&grid[x1][y]==1)
            {
                //do dfs for all reachable vertices

                isIsland(grid,x1,y,pair,bx,by);

            }
        }
        return true;
    }

    int countDistinctIslands(int[][] grid) {
        Set< List<List<Integer>>> set=new HashSet<>();
        for(int i=0;i<grid.length;i++)
        {
            //keep track of each cell
            for(int j=0;j<grid[i].length;j++)
            {
                //do dfs to visit each node and mark visited which indicates we dont visit again ad check all eight directions
                if(grid[i][j]==1)
                {
                    List<List<Integer>> pair=new ArrayList<>();
                    isIsland(grid,i,j,pair,i,j);
                    set.add(pair);
                }

            }
        }
        return set.size();
    }
}
