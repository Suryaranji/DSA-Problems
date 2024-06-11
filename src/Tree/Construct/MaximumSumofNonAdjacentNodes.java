package Tree.Construct;

import Tree.BinarySearch.Node;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofNonAdjacentNodes {
    /*
   Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.



Example 1:

Input:
    11
   /  \
  1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
       1
     /   \
    2     3
   /     /  \
  4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
   */
    static int getMax(Node root,Map<Node,Integer> map)
    {
        if(root==null)return 0;

        //map to keep track each node max sum

        if(map.containsKey(root))return map.get(root);

        int sum=root.data;
        // check grand child sum
        if(root.left!=null)
        {
            sum+=getMax(root.left.left,map);
            sum+=getMax(root.left.right,map);
        }
        if(root.right!=null)
        {
            sum+=getMax(root.right.left,map);
            sum+=getMax(root.right.right,map);
        }
        //check child sum
        int childsum=0;
        childsum+=getMax(root.left,map);
        childsum+=getMax(root.right,map);
        //choose which is maximum
        if(sum>childsum)
        {
            map.put(root,sum);
            return sum;
        }
        map.put(root,childsum);
        return childsum;

    }

    static int getMaxSum(Node root)
    {
        Map<Node,Integer> map=new HashMap<>();
        return getMax(root,map);
    }
}
