package Tree;

public class Subtree {
    static boolean equal(Node root1, Node root2)
    {
        if(root1==null&&root2==null)return true;
        if(root1==null||root2==null)return false;
        if(root1.data==root2.data)
        {
            return equal(root1.left,root2.left)&&equal(root1.right,root2.right);

        }
        return false;

    }
    public static boolean isSubtree(Node root, Node sub) {
        if(root!=null&&sub!=null)
        {
            //check whenever a node equal sub node if equal then return true
            if(root.data==sub.data&&equal(root,sub))
            {
                return true;
            }
            return isSubtree(root.left,sub)||isSubtree(root.right,sub);
        }
        return false;
    }
}
