package Tree.Construct;

import Tree.BinarySearch.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromParentArray {
    /*
   Given an array of size N that can be used to represents a tree. The array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.

Note: If two elements have the same parent, the one that appears first in the array will be the left child and the other is the right child.


Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like
         0
       /   \
      1     2
     / \
    3   4
   /
  5
/
6
Example 2:

Input:
N = 3
parent[] = {2, 0, -1}
Output: 2 0 1
Explanation: the tree generated will
have a sturcture like
              2
            /
           0
         /
        1
   */
    //Function to construct binary tree from parent array.
    public static Node createTree(int parent[], int N)
    {
        List<Node> queue=new ArrayList<>();
        //create all node add it to list
        for(int i=0;i<N;i++)
        {
            queue.add(new Node(i));
        }
        Node root=null;
        for(int i=0;i<N;i++)
        {
            //check if not root
            if(parent[i]!=-1)
            {
                // if not pick its parent
                Node par=queue.get(parent[i]);
                //if there is left child then place on right
                if(par.left==null)
                {
                    par.left=queue.get(i);
                }
                else
                {
                    par.right=queue.get(i);
                }
            }
            else
            {
                root=queue.get(i);
            }
        }
        return  root;
    }
}
