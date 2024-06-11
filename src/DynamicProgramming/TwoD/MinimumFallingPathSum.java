package DynamicProgramming.TwoD;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minimum(int n,int [][]grid,int parent,int index,int sum,int [][]dp)
    {
        if(index==n)
        {
            return sum;
        }
        if(dp[index][parent]!=-1)return dp[index][parent];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            // dont take parent from same column
            if(i!=parent)
            {
                min=Math.min(min,minimum(n,grid,i,index+1,grid[index][i],dp));

            }
        }
        //add sum finally
        dp[index][parent]=sum+min;
        return dp[index][parent];
    }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        //create a dp array to store cuurent row and parent
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,minimum(n,grid,i,1,grid[0][i],dp));

        }
        return min;

    }
}
