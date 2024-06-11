package Tree;

import java.util.ArrayList;
import java.util.List;

public class MORRISTRAVERSAL {
    public class TreeNode {
   int val;
      TreeNode left;
      TreeNode right;     TreeNode() {}
  TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null)
        {
            //if there are no left then it is current node add value and move to right
            if(cur.left==null)
            {
                answer.add(cur.val);
                cur=cur.right;
            }
            else
            {
                //if there is left then we have to assign leftmost of left right to curr
                TreeNode pre=cur.left;
                while(pre.right!=null&&pre.right!=cur)
                {
                    pre=pre.right;
                }
                //to go left
                if(pre.right==null)
                {
                    //if null make curr as right of that
                    pre.right=cur;
                    cur=cur.left;
                }
                //visited right
                else
                {
                    //set previous right to null add value and move to right
                    pre.right=null;
                    answer.add(cur.val);
                    cur=cur.right;
                }
            }

        }
        return answer;
    }
}
