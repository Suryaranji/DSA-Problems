package Slidingwindow;

import java.util.Arrays;

public class MAXFrequncy {
    /*
    The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.



Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
     */

    public int maxFrequency(int[] nums, int k) {


        Arrays.sort(nums);
        int l=0,r=0,max=0;
        long sum=0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(l<nums.length&&nums[r]*(r-l+1)>sum+k)
            {
                sum-=nums[l++];
            }

            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
