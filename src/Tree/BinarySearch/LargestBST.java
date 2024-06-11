package Tree.BinarySearch;

class Pair{
    int size;
    int large, small;
    Pair(int s,int l,int sm)
    {
        size=s;
        large=l;
        small=sm;
    }
}

class Solution{
    /*
    Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
    */
    static Pair largest(Node root)
    {
        if(root==null)return new Pair(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        Pair left=largest(root.left);
        Pair right=largest(root.right);
        if(left.large<root.data&&root.data<right.small)//check valid
        {
            //update cuurent large as max of root to right large and min ans min of left and root
            return new Pair(left.size+right.size+1,Math.max(right.large,root.data),Math.min(left.small,root.data));
        }
        return new Pair(Math.max(left.size,right.size),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        Pair p=largest(root);
        return p.size;


    }

}