package DynamicProgramming.TwoD;

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int n=obstacleGrid[0].length;
        int m=obstacleGrid.length;

        int []prev=new int [n];
        for(int i=0;i<m;i++)
        {
            int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]!=1){
                    if(i==0&&j==0)temp[j]=1;
                    else
                    {
                        int left=0,right=0;
                        //if there is  left part then we can pssible ome from there
                        if(j>0)left=temp[j-1];
                        //anyway take above
                        right=prev[j];
                        //curret has sum of left and above
                        temp[j]=left+right;
                    }
                }

            }
            prev=temp;
        }
        return prev[n-1];
    }
}
