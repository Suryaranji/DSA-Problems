package Tree;

import java.util.*;

public class NodesAtKDistance {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> answer=new ArrayList<>();

        //find target node and store parent of each node

        Queue<Node> queue=new LinkedList<>();
        // to store parent Node like child parent
        Map<Node,Node> map=new HashMap<>();
        Node targetNode=null;
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node temp=queue.remove();
            if(temp.data==target)targetNode =temp;
            if(temp.left!=null)
            {
                map.put(temp.left,temp);
                queue.add(temp.left);
            }
            if(temp.right!=null)
            {
                map.put(temp.right,temp);
                queue.add(temp.right);
            }
        }
        // System.out.println(map);
        if(targetNode ==null)return answer;
        //hashset for already  visites nodes
        Set<Node> set=new HashSet<>();
        queue.add(targetNode);
        while(k>0)
        {
            // remove until queue size
            int tempsize=queue.size();
            while(tempsize>0)
            {
                //
                Node temp=queue.remove();
                set.add(temp);
                // add left if not set vice versa for right and parent
                if(temp.left!=null&&!set.contains(temp.left))
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null&&!set.contains(temp.right))
                {
                    queue.add(temp.right);
                }
                if(map.containsKey(temp)&&!set.contains(map.get(temp)))queue.add(map.get(temp));
                tempsize--;
            }
            k--;
        }
        // add to list
        while(!queue.isEmpty())answer.add(queue.remove().data);
        //sort
        Collections.sort(answer);
        return answer;
    }
}

/*
class Solution
{

public static ArrayList<Integer>v = new ArrayList<Integer>();

    public static void findKDistanceDownNode(Node root, int k)
    {
            // Base Case
            if (root == null || k < 0)  return;

        // If we reach a k distant node, add to vector
        if (k==0)
        {
        v.add(root.data);
        return;
        }

        // Recur for left and right subtrees
        findKDistanceDownNode(root.left, k-1);
        findKDistanceDownNode(root.right, k-1);
        }

public static int findKDistanceNode(Node root, int target , int k)
        // Finds all nodes at distance k from a given target node.
        // The k distant nodes may be upward or downward.  This function
        // Returns distance of root from target node, it returns -1 if target
        // node is not present in tree rooted with root.
        {
        // Base Case 1: If tree is empty, return -1
        if (root == null) return -1;

        // If target is same as root.  Use the downward function
        // to find all nodes at distance k in subtree rooted with
        // target or root
        if (root.data == target)
        {
        findKDistanceDownNode(root, k);
        return 0;
        }

        // Recur for left subtree
        int dl = findKDistanceNode(root.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {
        // If root is at distance k from target, add root value to vector
        // Note that dl is Distance of root's left child from target
        if (dl + 1 == k)
        v.add(root.data);

        // Else go to right subtree and print all k-dl-2 distant nodes
        // Note that the right child is 2 edges away from left child
        else
        findKDistanceDownNode(root.right, k-dl-2);

        // Add 1 to the distance and return value for parent calls
        return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left subtree
        int dr = findKDistanceNode(root.right, target, k);
        if (dr != -1)
        {
        if (dr + 1 == k)
        v.add(root.data);
        else
        findKDistanceDownNode(root.left, k-dr-2);
        return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
        }



public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
        {
        v.clear();

        findKDistanceNode(root, target, k);

        Collections.sort(v);

        return v;
        }
 */
