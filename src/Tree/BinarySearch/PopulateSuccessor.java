package Tree.BinarySearch;

public class PopulateSuccessor {
    class Node {
        int data;
        Node left, right,next;

        public Node(int data){
            this.data = data;
        }
    }
    /*
   Given a Binary Tree, write a function to populate next pointer for all nodes. The next pointer for every node should be set to point to inorder successor.

Example 1:

Input:
      10
      /  \
     8    12
    /
   3


Output: 3->8 8->10 10->12 12->-1
Explanation: The inorder of the above tree is :
3 8 10 12. So the next pointer of node 3 is
pointing to 8 , next pointer of 8 is pointing
to 10 and so on.And next pointer of 12 is
pointing to -1 as there is no inorder successor
of 12.
Example 2:

Input:
      1
     /   \
    2     3
Output: 2->1 1->3 3->-1
   */
    public Node populate(Node root,Node parent)
    {

        if(root==null)return new Node(-1);
        //right part is gonna be our successor
        Node  right=populate(root.right,parent);
        if(right.data!=-1)//if -1 then there is no right part
        {
            root.next=right;
        }
        else if(right.data==-1&&parent!=null)// if no right then check for greater parent if exist
        {
            // System.out.println(root.data+" ->"+parent.data);
            root.next=parent;
        }
        Node left=populate(root.left,root);//left node doesn' contains any successor then its parent will be successor
        if(left.data!=-1&&left.data<root.data)return left;// then every right part should retunrn minmum among them
        return root;//else root is minimum
    }
    public void populateNext(Node root){
        populate(root,null);
    }
}
