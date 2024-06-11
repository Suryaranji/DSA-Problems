package Tree;

import java.util.ArrayList;

public class BoundaryTraversal {

    //left only traverse left subtree

    void left(Node root,ArrayList <Integer> answer)
    {
        if(root!=null)
        {
            //if left subtree has any leaf nodes thenit take care of leaf function same for right
            if(root.left==null&&root.right==null)
            {
                return ;
            }
            answer.add(root.data);
            /*


              1
             / \
             2  3
               /\
               4 5
              then 4 should also be printed this was checked here vice versa for right subtree
            */
            if(root.left!=null)
                left(root.left,answer);
            else left(root.right,answer);
        }
    }
    void right(Node root,ArrayList <Integer> answer)
    {
        if(root!=null)
        {
            if(root.right!=null)
                right(root.right,answer);
            else right(root.left,answer);
            if(root.left==null&&root.right==null)
            {
                return ;
            }
            answer.add(root.data);

        }
    }
    void leaf(Node root,ArrayList <Integer>answer)
    {
        if(root!=null)
        {
            if(root.left==null&&root.right==null)
            {
                answer.add(root.data);
            }
            leaf(root.left,answer);
            leaf(root.right,answer);
        }
    }
    ArrayList <Integer> boundary(Node root)
    {
        ArrayList<Integer> answer=new ArrayList<>();
        if(root==null)return answer;

        answer.add(root.data);
        if(root.left==null&&root.right==null) return answer;
        left(root.left,answer);
        leaf(root,answer);
        right(root.right,answer);

        return answer;

    }
}
