package Slidingwindow;

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        /*
        Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        Output: 6
        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
        Approach:
        whenever zero encountered increment count
        ones count over k then decrement start until zero occurs
        calculate  max between start to i

        */

        int count=0,start=0,max=0;
        for(int i=0;i<nums.length;i++)
        {
            //whenever zero encountered increment count
            if(nums[i]==0)
            {
                count++;
            }
            // ones count over k then decrement start until zero occurs
            if(count>k)
            {
                while(nums[start]==1)
                {
                    start++;
                }
                count--;
                start++;
            }
            //calculate  max between start to i
            //System.out.println(start+" "+i);
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}
