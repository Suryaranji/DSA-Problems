package Tree.Construct;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class POSTORDERINORDER {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public TreeNode build(int[]inorder, int[]postorder, int instart, int inend, int posstart, int posend, Map<Integer,Integer> map)
    {
        if(instart>inend||posstart>posend)return null;
        TreeNode root=new TreeNode(postorder[posend]);
        int mid=map.get(root.val);
        int numright=inend-mid;
        root.left=build(inorder,postorder,instart,mid-1,posstart,posend-numright-1,map);
        root.right=build(inorder,postorder,mid+1,inend,posend-numright,posend-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,0,n-1,0,n-1,map);

    }
}
