package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    /*
    Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtress then left subtree diagonal element should be taken first and then right subtree.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
     */
    class Pair
    {
        Node node;
        int level;
        Pair(Node node,int level)
        {
            this.node=node;
            this.level=level;
        }
    }
    class Tree
    {
        public ArrayList<Integer> diagonal(Node root)
        {
            //queue to keep track of each nodes and their levels
            Queue<Pair> queue=new LinkedList<>();
            ArrayList<Integer> ans=new ArrayList<>();
            queue.add(new Pair(root,0));
            int level=0;
            while(!queue.isEmpty())
            {
                Node temp=queue.remove().node;
                //track all right nodes beacause they are all lying in same diagonal
                while(temp!=null)
                {
                    ans.add(temp.data);
                    //if any left insert in queue along with level
                    if(temp.left!=null)queue.add(new Pair(temp.left,level-1));
                    temp=temp.right;
                }
                //levelupdated
                level=queue.isEmpty()?-1:queue.peek().level;
            }
            return ans;
        }
    }
}
