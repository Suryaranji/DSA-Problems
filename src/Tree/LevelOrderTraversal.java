package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class LevelOrderTraversal {

    static ArrayList<Integer> levelOrder(Node root)
    {
        ArrayList<Integer> answer=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp=queue.remove();
            answer.add(temp.data);

            if(temp.left!=null)
            {
                queue.add(temp.left);
            }
            if(temp.right!=null)
            {
                queue.add(temp.right);
            }
        }
        return answer;
    }
}
