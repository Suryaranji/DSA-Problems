package Slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    // Function for finding maximum and value pair
   /* Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.*/

    /*

    Approach use hashmap to store sum as key and their indexes
     //check whether initial sum ==k if that happens then length will upto that point
     //if map contains the prefix sum then there is that sum just calculate its length
     //don't update latest sum because we need maximum-length
    // if we update sum which we already have then it won't be our max sum
    https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?page=1&category=sliding-window&sortBy=submissions
    */
    public static int lenOfLongSubarr (int A[], int N, int K) {
        int maximumlength=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        //map.put(0,-1);
        for(int i=0;i<N;i++)
        {
            sum+=A[i];
            //check whether initial sum ==k if that happens then length will upto that point
            if(sum==K)
            {
                maximumlength=Math.max(maximumlength,i+1);
            }
            //if map contains the prefix sum then there is that sum just calculate its length
            if(map.containsKey(sum-K))
            {
                maximumlength=Math.max(maximumlength,i-map.get(sum-K));
            }
            //dont update latest sum because we need maximumlength
            // if we update sum which we already have then it wont be our maxsum
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return maximumlength;
    }

}
