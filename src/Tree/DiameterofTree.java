package Tree;

public class DiameterofTree {
    /*
The diameter of a tree (sometimes called the width) is the number of nodes on the longest
path between two end nodes. The diagram below shows two trees
each with diameter nine, the leaves that form the ends of the longest path
are shaded (note that there is more than one path in each tree of length nine,
but no path longer than nine nodes).

Input:
     10
    /   \
  20    30
/   \
40   60
Output: 4


*/
    int max=0;
    int maxDistance(Node root)
    {
        if(root==null)return 0;
        int left=maxDistance(root.left);
        int right=maxDistance(root.right);
        //check for long diameter if so ipdate
        max=Math.max(max,left+right+1);
        //then return the maximum
        return Math.max(left,right)+1;
    }
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        maxDistance(root);
        return max;
    }
}
