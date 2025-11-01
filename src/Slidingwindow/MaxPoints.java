package Slidingwindow;

import java.util.Arrays;

public class MaxPoints {

    public int max(int cards[], int i, int j, int k, int dp[][]) {
        if (k == 0 || i > j) {
            return 0;
        }
        if (i == j) {
            return cards[i];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxScore = 0;
        maxScore += Math.max(cards[j] + max(cards, i, j - 1, k - 1, dp), cards[i] + max(cards, i + 1, j, k - 1, dp));

        return dp[i][j] = maxScore;
    }

    public int maxScore(int[] cardPoints, int k) {
/*        int n = cardPoints.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return max(cardPoints, 0, cardPoints.length - 1, k, dp);*/
        int sum=Arrays.stream(cardPoints).sum();
        int n=cardPoints.length;
        if(k>=n)return sum;
        int windowSize=n-k;
        int windowSum=0;
        for(int i=0;i<windowSize;i++) {
            windowSum+=cardPoints[i];
        }
        int minSum=windowSum;
        for(int i=windowSize;i<n;i++){
            windowSum+=cardPoints[i]-cardPoints[i-windowSize];
            minSum=Math.min(minSum,windowSum);
        }
        return sum-minSum;

    }

    public static void main(String[] args) {
        MaxPoints obj = new MaxPoints();
        int cards[] = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(obj.maxScore(cards, k));
    }

}
