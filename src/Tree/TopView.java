package Tree;



import java.util.*;

class PairTree
{
    int level;
    Node node;
    PairTree(Node n,int l)
    {
        node =n;
        level=l;
    }
}
public class TopView {
    static ArrayList<Integer> topView(Node root)
    {


        /*
        recursion Won't work because
        eg:
                       1
                      / \
                     2  3
                      \
                      4
                       \
                        5
        If we do inorder traversal we end up 5 first but, we need 3
        */
        // checks for existence of that previous level and also organizes based on key
        Map<Integer,Integer> map=new TreeMap<>();
        //to store final answer
        ArrayList<Integer> answer=new ArrayList<>();
        // to keep track of values
        Queue<PairTree> queue=new LinkedList<>();
        if(root==null)return answer;
        queue.add(new PairTree(root,0));
        while(!queue.isEmpty())
        {
            PairTree temp=queue.remove();
            Node node=temp.node;
            int level=temp.level;
            //if there is no level previously add to map
            if(!map.containsKey(level))
            {
                //for bottom view took checking condition and add new values when it overrides previous
                map.put(level,node.data);
            }
            // insert left or right node if exist
            if(node.left!=null)
            {
                queue.add(new PairTree(node.left,level-1));
            }
            if(node.right!=null)
            {
                queue.add(new PairTree(node.right,level+1));
            }
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet())
        {
            answer.add(entry.getValue());
        }


        return answer;

    }
}
