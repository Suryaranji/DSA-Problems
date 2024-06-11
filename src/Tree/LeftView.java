package Tree;

import java.util.ArrayList;

public class LeftView {
    int maxlevel=-1;
    void leftView(Node root,ArrayList<Integer> answer,int level)
    {
        if(root!=null)
        {
            if(maxlevel<level)
            {
                answer.add(root.data);
                maxlevel=level;
            }

            leftView(root.left,answer,level+1);

            leftView(root.right,answer,level+1);
        }
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        //take node having level greater than maxlevel
        // less than indicates it has already been identified
        ArrayList<Integer> answer=new ArrayList<>();

        leftView(root,answer,0);
        return answer;
    }
}
