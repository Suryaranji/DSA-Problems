package DynamicProgramming.TwoD;

import java.util.Arrays;

public class KSum {
    long ways(int n,int k,int [][]arr,long dp[][][],int i,int j,int coins)
    {
        //if rerached last index
        if(i==n-1&&j==n-1)
        {

            //check remaining sum== to curr index if return 1
            if(k-coins==arr[i][j])return 1;
            return 0;
        }
        //if exceeds return 0
        if(coins>k||i>=n||j>=n)return 0;
        if(dp[i][j][coins]!=-1)return dp[i][j][coins];
        // do for remaining stuffs

        dp[i][j][coins]=ways(n,k,arr,dp,i+1,j,coins+arr[i][j])+ways(n,k,arr,dp,i,j+1,coins+arr[i][j]);
        return dp[i][j][coins];
    }
    long numberOfPath(int n, int k, int [][]arr) {
        //create a 3d array to store current sum as well as indexes
        long dp[][][]=new long [n][n][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }

        }
        return  ways(n,k,arr,dp,0,0,0);

    }
}
