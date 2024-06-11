package Tree;

import java.util.ArrayList;
import java.util.Collections;

class PairNode
{
    int data,level,vertical;
    PairNode(int data,int l,int v)
    {
        this.data=data;
        this.level=l;
        this.vertical=v;
    }
}
class Solution
{

    static  void traversal(Node root,ArrayList<PairNode> nodes,int level,int vertical)
    {
        if(root!=null)
        {
            //track the level and vertical
            PairNode newnode=new PairNode(root.data,level,vertical);
            nodes.add(newnode);
            //if left then v-1 level increase
            traversal(root.left,nodes,level+1,vertical-1);
            traversal(root.right,nodes,level+1,vertical+1);
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root)
    {
        ArrayList<PairNode> nodes=new ArrayList<>();
        traversal(root,nodes,0,0);
        Collections.sort(nodes,(a, b)->{
            if(a.vertical== b.vertical)return a.level-b.level;
            return a.vertical- b.vertical;
        });
        ArrayList<Integer> answer=new ArrayList<>();
        for(PairNode i : nodes)answer.add(i.data);
        return answer;

    }
}