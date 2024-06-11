package Tree.BinarySearch;

public class KthLargest {
      /*
    Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Example 1:

Input:
      4
    /   \
   2     9
k = 2
Output: 4
Example 2:

Input:
       9
        \
          10
K = 1
Output: 10
    */

    int max=0;
    int count=0;
    public void  large( Node root,int k)
    {

        if(root==null)return ;

        //visit right
        large(root.right,k);
        //increase count
        count++;
        if(count==k)
        {
            max=root.data;
            return ;
        }
        large(root.left,k);



    }

    public int kthLargest(Node root,int k)
    {
        large(root,k);
        return max;
    }
}
