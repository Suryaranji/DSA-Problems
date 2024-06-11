package DynamicProgramming.Subsequences;

public class PartitionProblem {
    static int partition(int[] arr,int index,int sum)
    {
        if(index==0)
        {
            if(sum==0||sum==arr[0])return 1;
            return 0;
        }
        int unpick=partition(arr,index-1,sum);
        int pick=0;
        if(arr[index]<=sum)
            pick=partition(arr,index-1,sum-arr[index]);
        return unpick+pick;
    }
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i:arr)sum+=i;
        if(sum%2!=0)return 0;
        //return partition(arr,N-1,sum/2)==0?0:1;
        sum=sum/2;
        int dp[][]=new int [N][sum+1];
        if(arr[0]<=sum)dp[0][arr[0]]=1;
        for(int i=0;i<N;i++)dp[i][0]=1;
        for(int i=1;i<N;i++)
        {
            for(int s=0;s<=sum;s++)
            {
                int unpick=dp[i-1][s];
                int pick=0;
                if(arr[i]<=s)
                    pick=dp[i-1][s-arr[i]];
                dp[i][s]=unpick+pick;

            }
        }
        return dp[N-1][sum]==0?0:1;
    }
}
