package Tree;

public class LowestCommonAncestor {
        /*
    Given a Binary Tree with all unique values and two nodes value, n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them are present.

LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

Example 1:

Input:
n1 = 2 , n2 = 3
       1
      / \
     2   3
Output: 1
Explanation:
LCA of 2 and 3 is 1.
Example 2:

Input:
n1 = 3 , n2 = 4
           5
          /
         2
        / \
       3   4
Output: 2
Explanation:
LCA of 3 and 4 is 2.
Example 3:

Input:
n1 = 5 , n2 = 4
           5
          /
         2
        / \
       3   4
Output: 5
Explanation:
LCA of 5 and 4 is 5.
    */
    //Function to return the lowest common ancestor in a Binary Tree.

    Node ancestor=null;
    boolean ances(Node root,int n1,int n2)
    {
        if(root==null) return false;
        boolean left=ances(root.left,n1,n2);
        boolean right=ances(root.right,n1,n2);

        //check if both left and right return true it indicates
        // both are found  and if any ancestor previously not marked mark current ass ancestor
        if((left&&right)&&ancestor==null)
        {
            ancestor=root;
            return true;
        }
        //if either of left or right is true then check of it current node equals to any node if true mark true
        if((left||right)&&(root.data==n1||root.data==n2))
        {
            ancestor=root;
            return true;
        }
        //else return previous boolean and current node equilance
        return (root.data==n1||root.data==n2)||(left||right);
    }
    Node lca(Node root, int n1,int n2)
    {
        ances(root,n1,n2);
        return ancestor;
    }
   /* Node lca(Node root, int n1,int n2)
    {

        if(root==null)
            return null;

        //if either n1 or n2 matches with data at current node, we return root.
        // (Note that if a node is ancestor of other, then the ancestor node
        //becomes the lowest common ancestor).
        if(root.data==n1 || root.data==n2)
            return root;

        //calling the lca function recursively for left and right subtrees.
        Node l = lca(root.left,n1,n2);
        Node r = lca(root.right,n1,n2);

        //if both of the above calls return non-NULL value then one node
        //is present in one subtree and other is present in another subtree.
        //So, this node is the lowest common ancestor.
        if(l != null && r != null)
            return root;


        //else we check if left subtree or right subtree is the
        //lowest common ancestor.
        return(l!=null)?l:r;
    }*/
}
