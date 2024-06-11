package DynamicProgramming.Subsequences;

public class SubsetSum {
    public int  isSub(int N,int[] arr,int index,int sum,int dp[][])
    {

        //go until to last inex

        if(index==-1)
        {
            if(sum==0)return 1;
            return 0;
        }

        if(dp[index][sum]!=-1)return dp[index][sum];
        int unpick=isSub(N,arr,index-1,sum,dp);
        int pick=0;
        if(arr[index]<=sum)pick=isSub(N,arr,index-1,sum-arr[index],dp);
        dp[index][sum]=(int)((unpick+pick)%(1e9+7));
        return dp[index][sum];


    }
    public int perfectSum(int arr[],int N, int target)
    {
        int dp[][]=new int [N][target+1];
        //for(int i=0;i<N;i++)Arrays.fill(dp[i],-1);
        //return isSub(N,arr,N-1,sum,dp);
        for(int i=0;i<N;i++)dp[i][0]=1+((arr[i]==0)?1:0);
        if(arr[0]!=0&&arr[0]<=target)dp[0][arr[0]]=1;
        for(int  i=1;i<N;i++)
        {
            for(int sum=0;sum<=target;sum++)
            {
                int unpick=dp[i-1][sum];
                int pick=0;
                if(arr[i]<=sum)pick=dp[i-1][sum-arr[i]];
                dp[i][sum]=(int)((unpick+pick)%(1e9+7));
            }
        }
        return dp[N-1][target];
    }
}
