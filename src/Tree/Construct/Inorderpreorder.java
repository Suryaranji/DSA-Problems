package Tree.Construct;

import Tree.BinarySearch.Node;


public class Inorderpreorder {
    /*
   Given 2 Arrays of Inorder and preorder traversal. The tree can contain ''''duplicate''' elements. Construct a tree and print the Postorder traversal.

Example 1:

Input:
N = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
N = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
      0
   /     \
  1       2
/   \    /
3    4   5
   */
    public static Node solve(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        Node root = new Node(pre[preStart]);

        // since tree can contain duplicate elements then map get only unique value
        //to resolve this we can just search the element only in that particular interval
        int mid = getPos(in, inStart, inEnd, root.data);
        int leftTreeCnt = mid - inStart;

        root.left = solve(pre, in, preStart + 1, preStart + leftTreeCnt, inStart, mid - 1);
        root.right = solve(pre, in, preStart + leftTreeCnt + 1, preEnd, mid + 1, inEnd);
        return root;
    }

    private static int getPos(int[] arr, int start, int end, int value) {
        //if value is there then just return index
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) return i;
        }

        return -1;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {



        return solve(preorder,inorder,0,n-1,0,n-1);
    }
}
