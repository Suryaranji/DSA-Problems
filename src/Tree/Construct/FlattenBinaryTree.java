package Tree.Construct;

import Tree.BinarySearch.Node;

public class FlattenBinaryTree {

    /*
    Given the root of a binary tree, flatten the tree into a "lLinked list":

The "linked list" should use the same Node class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
Example 1:

Input :
          1
        /   \
       2     5
      / \     \
     3   4     6
Output :
1 2 3 4 5 6
Explanation:
After flattening, the tree looks
like this
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
Here, left of each node points
to NULL and right contains the
next node in preorder.The inorder
traversal of this flattened tree
is 1 2 3 4 5 6.
    */

    public static void flatten(Node root)
    {
        Node cur=root;
        while(cur!=null)
        {

            // if there is no left then we dont disturb just move rigt
            if(cur.left!=null)
            {


                Node pred=cur.left;

                while(pred.right!=null)
                    pred=pred.right;
                //if not pick right most and make its right as curre right
                pred.right=cur.right;
                //and cur right as left
                cur.right=cur.left;
                //and left as null to not keep left
                cur.left=null;
            }
            cur=cur.right;
        }

    }
}
