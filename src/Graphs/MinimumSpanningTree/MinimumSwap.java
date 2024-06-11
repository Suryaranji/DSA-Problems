package Graphs.MinimumSpanningTree;

import java.util.Arrays;

class Pair{
    int number ,index;
    Pair(int number,int index)
    {
        this.number=number;
        this.index=index;
    }
}

class Solution
{
    /*
    Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explanation:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.
    */

    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {

        int n=nums.length;
        Pair[] arr=new Pair[nums.length];
        //create a pair of value and index
        for(int i=0;i<n;i++)
        {
            arr[i]=new Pair(nums[i],i);
        }
        //sort values
        Arrays.sort(arr,(a, b)->a.number-b.number);
        int index=0;
        int swaps=0;
        while(index<n)
        {
            //if both cur index and element index is not same then we need swap
            if(arr[index].index!=index)
            {
                Pair temp=arr[index];
                arr[index]=arr[temp.index];
                arr[temp.index]=temp;
                swaps++;
                index--;
            }
            index++;
        }
        return swaps;
    }
}