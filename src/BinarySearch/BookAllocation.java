package BinarySearch;

import java.util.ArrayList;

public class BookAllocation {

    /*
    * CodingStudio:https://www.codingninjas.com/studio/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTab=1
    *
    * Description:
    *              The problem describes that we have to allocate n books to m students such that each student get atleast one book
    *              and the student who gets maximum number of  pages needs to be as minimum as possible.
    * Approach:
    *
    * Our answer is between the maximum no of pages(if n==m) and sum of all pages(m==1)
    *
    * Brute force :
    *
    * use linear search from max to min to find if we can allocate to m students and that can give as minimum possibility
    *
    * Optimal Approach:(Binary Search)
    *
    *  Use the above technique instead of using linear search use binary search
    * if we can allocate to more than or equal to m students then we move right
    * else move left
    *
    * Time Complexity:O(n log(n))
    * Space Complexity:O(1)
    *
     */
    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        /*input:
               arr[]={12,34,67,90} n=4 m=2
         output :
                maximum possible 113
         */
        int left=0,right=0;
        if(m>n)return -1;

        for(int i=0;i<n;i++)
        {
            right+=arr.get(i);
            left=Math.max(arr.get(i),left);
        }
        while(left<=right)
        {
            int mid=left+(right-left)/2;

            int man=0;
            int pages=0;
            for(int i=0;i<n;i++)
            {
                if(pages+arr.get(i)<=mid)pages+=arr.get(i);
                else
                {
                    man++;
                    pages=arr.get(i);
                }
            }
            if(pages>0)man++;
            if(man>m)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return left;

    }
    /*
    Similar problems:-
    LeetCode:-https://leetcode.com/problems/split-array-largest-sum/description/
    CodeStudio:https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
     */
}
