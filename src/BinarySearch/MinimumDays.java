package BinarySearch;

public class MinimumDays {
    public static  int minDays(int[] bloomDay, int m, int k) {

        /*
           Problem Leetcode:1482->"https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/"
           Qn.Find minimum no of days needed to make m bouquets.
           inputs:bloomDay array -> defines blooming day of each ith  flower
           int m: Number of Bouquets to make.
           int K: must choose adjacent number of flower

           Time Complexity:O(N*log(maximum day-minimum day))
           Space Complexity:O(1)

           Approach:
           * The answer is between minimum day and maximum days
           * So apply binary search to find minimum days needed to make m bouquets.
           *  traverse entire array if it is possible to make m bouquets by k adjacent flowers for each middle element
           * if Possible to make m bouquets  or more save the answer and move left of mid to check if any other  possible answers.
           * else move towards right .

           * Similar problems:
           LeetCode 1283:https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
           LeetCode 1011;https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
           CodeStudio:https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
         */
        int n=bloomDay.length;
        if(n/k<m)
        {
            return -1;
        }
        int first=Integer.MAX_VALUE;
        int last=-1;
        for(int flower:bloomDay)
        {
            if(flower<first)first=flower;
            if(flower>last)last=flower;
        }
        int ans=-1;
        while(first<=last)
        {
            int mid=last+(first-last)/2;
            int count=0;
            int bouquets=0;
            for(int flower :bloomDay)
            {
                if(flower<=mid)
                {
                    count++;
                }
                else
                {
                    bouquets+=(count/k);
                    count=0;
                }
            }
            bouquets+=count/k;
            if(bouquets>=m)
            {
                ans=mid;
                last=mid-1;
            }
            else
            {
                first=mid+1;
            }
        }
        return ans;

    }
}
