package Heaps.problems;

public class MinimumCostToConnectNStones {
    public int min(int i, int j,int pile,int []prefixSum,int k,int dp[][][]){
        if(i==j&&pile==1)return 0;
        if(i==j)return Integer.MAX_VALUE/4;
        if(dp[i][j][pile]!=-1)return dp[i][j][pile];
        int ans=Integer.MAX_VALUE/4;
        if(pile==1){
            ans=min(i,j,k,prefixSum,k,dp)+prefixSum[j+1]-prefixSum[i];
        }else{
            for(int p=i;p<j;p++){
                ans=Math.min(ans,min(i,p,1,prefixSum,k,dp)+min(p+1,j,pile-1,prefixSum,k,dp));
            }
        }
        return dp[i][j][pile]=ans;
    }
    public int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if((n-1)%(k-1)!=0)return -1;
        int prefixSum[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+stones[i];
        }
        int[][][] dp =new int[n][n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<=k;p++){
                    dp[i][j][p]=-1;
                }
            }
        }
        return min(0,n-1,1,prefixSum,k,dp);

    }

    public static void main(String[] args) {
        MinimumCostToConnectNStones obj=new MinimumCostToConnectNStones();
        int stones[]={3,2,4,1};
        int k=2;
        System.out.println(obj.mergeStones(stones,k));
    }
}
