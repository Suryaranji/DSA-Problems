package Tree;

public class Balanced {
    int balanced(Node root)
    {
        if(root==null)return 0;
        int left=balanced(root.left);
        int right=balanced(root.right);
        //if anyone node violates height property then return -1;
        if(left==-1||right==-1)return -1;
        // if the difference between height are more than 1 then return -1;
        if(Math.abs(left-right)>=2)return -1;
        //just return the max of left of right +1;
        return Math.max(left,right)+1;
    }
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        return balanced(root)!=-1;
    }
}
