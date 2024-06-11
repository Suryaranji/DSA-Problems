package BinarySearch;

public class PeakElement2 {
    /**
     A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

     Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

     You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

     You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.



     Example 1:



     Input: mat = [[1,4],[3,2]]
     Output: [0,1]
     Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
     Example 2:



     Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
     Output: [1,1]
     Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
     */
    public int maxfind(int [][]mat,int col)
    {
        int row=0;
        for(int i=1;i<mat.length;i++)
        {
            if(mat[row][col]<mat[i][col])
            {
                row=i;
            }
        }
        return row;
    }
    public int[] findPeakGrid(int[][] mat) {

        //pick a column
        int low=0,high=mat[0].length-1;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            //pick a row having max element
            int row=maxfind(mat,mid);
            //consider left and right elements
            int left=mid-1<0?-1:mat[row][mid-1];
            int right=mid+1>=mat[0].length?-1:mat[row][mid+1];
            //if mid greater than both then return current as peak element
            if(left<mat[row][mid]&&right<mat[row][mid])
            {
                return new int[]{row,mid};
            }
            else if(left>mat[row][mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }

        }
        return new int[]{-1,-1};

    }
}
