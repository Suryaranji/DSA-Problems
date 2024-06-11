package Tree;

public class Symmetry {
    static boolean equal(Node root1, Node root2)
    {
        if(root1==null&&root2==null)return true;
        if(root1==null||root2==null)return false;
        if(root1.data==root2.data)
        {
            // left part has to be equal to right part vice versa
            return equal(root1.left,root2.right)&&equal(root1.right,root2.left);

        }
        return false;

    }
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if(root==null)return true;
        return equal(root.left,root.right);

    }
}
