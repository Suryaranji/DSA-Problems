package Tree.BinarySearch;

public class FindInOrderPredOrSucc {
    static Node pre,suc;
    public static void findPreSuc(Node root, int key)
    {
    /*
    There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor.

Example 1:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 8 Output:
4 9 Explanation:
In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.
Example 2:

Input:
        10
      /   \
     2    11
   /  \
  1    5
      /  \
     3    6
      \
       4
key = 11 Output:
10 -1 Explanation:
In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.
    */
        // code here.

    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code.
    */
        Node large=null,small=null,target=null;
        Node temp=root;
        while(temp!=null)
        {
            if(temp.data==key)
            {
                target=temp;
                break;
            }
            else if(temp.data<key)
            {
                //keep track of small beacause it may be our predecessor if we cant find any left max vice versa for large
                small=temp;
                temp=temp.right;
            }
            else
            {
                large=temp;
                temp=temp.left;
            }
        }
        if(target!=null)
        {
            //check if there are any left max else put small as pred vice versa
            Node pred=target.left;
            while(pred!=null)
            {
                pre=pred;
                pred=pred.right;
            }
            if(pre==null)pre=small;
            Node succ=target.right;
            while(succ!=null)
            {
                suc=succ;
                succ=succ.left;
            }
            if(suc==null)suc=large;
        }
        else
        {
            pre=small;
            suc=large;
        }


    }
}
