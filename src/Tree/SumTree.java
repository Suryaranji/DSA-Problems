package Tree;

public class SumTree {
    /*
    Given a Binary Tree. Return true if, for every node X in the tree other than the leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.

An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.


Example 1:

Input:
    3
  /   \
 1     2

Output: 1
Explanation:
The sum of left subtree and right subtree is
1 + 2 = 3, which is the value of the root node.
Therefore,the given binary tree is a sum tree.
Example 2:

Input:

          10
        /    \
      20      30
    /   \
   10    10

Output: 0
Explanation:
The given tree is not a sum tree.
For the root node, sum of elements
in left subtree is 40 and sum of elements
in right subtree is 30. Root element = 10
which is not equal to 30+40.
     */
    int balanced(Node root)
    {
        if(root==null)return 0;
        int left=balanced(root.left);
        int right=balanced(root.right);
        //if anyone node violates height property then return -1;
        if(left==-1||right==-1)return -1;
        //if any left or right is not leaf and sum is not equal to root.data then return -1
        if((left!=0||right!=0)&&left+right!=root.data)return -1;

        //return total sum;
        return left+right+root.data;
    }
    boolean isSumTree(Node root)
    {
        return balanced(root)!=-1;
    }
}
