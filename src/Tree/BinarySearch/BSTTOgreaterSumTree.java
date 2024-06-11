package Tree.BinarySearch;

public class BSTTOgreaterSumTree {
    /*
  Given a BST with unique node values, transform it into greater sum tree where each node contains sum of all nodes greater than that node.

Example 1:

Input:
         2
       /    \
      1      6
            /  \
           3    7
Output: 18 16 13 7 0
Explanation:
Every node is replaced with the
sum of nodes greater than itself.
The resultant tree is:
             16
           /    \
         18       7
                /   \
               13    0
  */
    public static int transform(Node root,int sum)
    {
        if(root==null)return 0;
        //goes to right
        int right=transform(root.right,sum);
        //store root data
        int temp=root.data;
        //change root data using sum+right
        root.data=right+sum;
        //send left the sum right and temp
        int left=transform(root.left,sum+right+temp);
        //return sum of all three
        return right+temp+left;
    }
    public static void transformTree (Node root)
    {
        transform(root,0);
    }
}
