package DynamicProgramming.Linear;

public class HouseRobberI {
    public int rob(int[] nums) {

        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        //may take 1 if large or 2
        int ways[]={nums[0],Math.max(nums[0],nums[1])};
        for(int i=2;i<nums.length;i++)
        {
            //same here either take cuurent or previous
            ways[i%2]=Math.max(ways[(i-1)%2],nums[i]+ways[(i-2)%2]);
        }

        return ways[((n+1)%2)];

    }
}
