package BinarySearch;

public class SearchInRotatedSortedArray {
    public boolean search(int[] nums, int target) {

        int low=0,high=nums.length-1;
        /*
        If there are any duplicates then remove it .it can also be done inside loop
        //to check either left half is sorted
        to check whether left part may have target element
        to check whether right part may have target element
        */
        while(low<=high&&nums[low]==nums[high])
        {
            if(nums[low]==target)return true;
            low++;
            high--;
        }
        while(low<=high)
        {
            int mid=(low+high)>>1;

            if(nums[mid]==target)
            {
                return true;
            }
            //to check either left half is sorted
            if(nums[low]<=nums[mid])
            {
                //to check whether left part may have target element
                if(nums[low]<=target&&target<=nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                //to check whether right part may have target element
                if(target<=nums[high]&&target>=nums[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }

            }
        }
        return false;

    }
}
