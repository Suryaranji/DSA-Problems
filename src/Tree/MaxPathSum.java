package Tree;

public class MaxPathSum {
    /*
    Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:

Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.
Example 2:

Input:
     10
   /    \
  2      5
          \
          -2
Output: 17
Explanation: Path in the given tree goes
like 2 , 10 , 5 which gives the max sum
as 17.
     */
    int max=Integer.MIN_VALUE;
    int findmax(Node root)
    {
        if(root==null)return 0;
        //call for post order traversa;
        int left=findmax(root.left);
        int right=findmax(root.right);
        //store root data
        int tempmax=root.data;
        //if left part +root > then add vice cersa for right
        if(root.data+left>tempmax)tempmax+=left;
        if(tempmax+right>tempmax)tempmax+=right;
        // update maxiumum
        if(tempmax>max)max=tempmax;
        //twist is we are gonna send ony maximum sum path
        // either left or right or without them
        return Math.max(root.data,Math.max(root.data+left,root.data+right));


    }
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node)
    {
        findmax(node);
        return max;
    }
}
