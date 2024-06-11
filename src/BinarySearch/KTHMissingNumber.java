package BinarySearch;

public class KTHMissingNumber {
    public int findKthPositive(int[] arr, int k) {


        /*
        * LeetCode:1539-https://leetcode.com/problems/kth-missing-positive-number/submissions/1056790261/
        *
        * Topic Binary Search
        *
        * Description:
        * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
        * Return the kth positive integer that is missing from this array.
        *
        * Approach:
        * Binary Search:
        * 1. Check middle index if element, and  it's index count are equal
        * 2. then our missing part would be on the right side
        * 3.else  that on the left side
        * once left cross over right
        * our element would be between right and left
        * exactly the element will be right+k+1
        *
        * Time Complexity=O(log n)
        * Space Complexity=O(1)
         */
        int left=0,right=arr.length-1;
        while(left<=right)
        {
            int mid=(left+right)>>1;
            if(arr[mid]-(mid+1)<k)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }

        }
        return right+k+1;

    }
}
