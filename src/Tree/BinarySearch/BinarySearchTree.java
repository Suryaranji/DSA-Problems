package Tree.BinarySearch;

public class BinarySearchTree {
    Node root;
    public void add(int data)
    {
        Node newNode=new Node(data);
        if(root==null)
        {
            root=newNode;
            return;
        }
        else
        {
            insert(root,newNode);
        }
    }
    public void insert(Node root,Node newNode)
    {
           if(root.data< newNode.data)
           {
               if(root.right!=null)
                 insert(root.right,newNode);
               else root.right=newNode;
               return;
           }
          if(root.left!=null)
            insert(root.left,newNode);
          else root.left=newNode;

    }
    public void inorder()
    {
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root)
    {
        if(root!=null)
        {
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
    }
}
