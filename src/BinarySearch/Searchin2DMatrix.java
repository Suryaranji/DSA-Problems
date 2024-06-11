package BinarySearch;

import java.util.ArrayList;

public class Searchin2DMatrix {
    /*
    * LeetCode:74 :https://leetcode.com/problems/search-a-2d-matrix-ii/
    * You are given an m x n integer matrix  with the following two properties:
    * Each row is sorted in non-decreasing order.
    * The first integer of each row is greater than the last integer of the previous row.
    * Given an integer target, return true if target is in matrix or false otherwise.
    * You must write a solution in O(log(m * n)) time complexity
    *
    *
    * Approach :
    * Brute Force:
    *             Search every element in 2d matrix( complexity O(n2) ).
    * Better Approach:
    *         * go to each row apply binary search.
    *         * Time Complexity=O(nlog(m))
    * Optimal approach:
    *         * start with bottom left corner or top right corner.
    *         * both these corners have those row and column values are in  increasing and decreasing order
    *         *Hence if the cell(corner) contains target return
    *         * else less than target then move to bottom
    *         * else move left
    * Time Complexity =O(m+n)
    * Space Complexity=O(1)
     */
    public static  boolean searchMatrix(int[][] matrix, int target) {

        int left=0,right=matrix[0].length-1;
        while(left<matrix.length&&right>=0)
        {
            if(matrix[left][right]==target)
            {
                return true;
            }
            else if(matrix[left][right]<target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return false;
    }
    /*
    * version 2
    * here each row is sorted
    * and last element of previous row is smaller than first element of current row
    * hence we flattened the array into 1d array
    * to get row and column
    * row=middle/col column=middle%col
    * Time Complexity=O(log(m*n))
    * space Complexity=o(1)
     */
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int left=0,right=mat.size()*mat.get(0).size()-1;
        int col=mat.get(0).size();
        while(left<=right)
        {
            int mid=(left+right)>>1;
            if(mat.get(mid/col).get(mid%col)==target)
            {
                return true;
            }
            else if(mat.get(mid/col).get(mid%col)<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return false;
    }
}
