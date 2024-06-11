package BinarySearch;

public class Minimum {
    static int minNumber(int nums[], int low, int high)
    {
        int target=Integer.MAX_VALUE;
        if(nums[low]<nums[high])return nums[low];
        while(low<=high)
        {
            int mid=(low+high)>>1;
            //if target smaller than mid then just makes target as mid
            if(nums[mid]<target)
            {
                target=nums[mid];
            }
            //check if right dont have grater elements elements
            if(nums[mid]<=nums[high])
            {
                high=mid-1;
            }
            else
            {

                low=mid+1;
            }
        }
        return target;
    }
}
