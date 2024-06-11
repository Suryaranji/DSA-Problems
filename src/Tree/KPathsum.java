package Tree;

import java.util.HashMap;
import java.util.Map;

public class KPathsum {
    /*
   Given a binary tree and an integer K. Find the number of paths in the tree which have their sum equal to K.
A path may start from any node and end at any node in the downward direction.

Example 1:

Input:
Tree =
         1
       /   \
      2     3
K = 3
Output:
2
Explanation:
Path 1 : 1 + 2 = 3
Path 2 : only leaf node 3
Example 2:

Input:
Tree =
          1
       /     \
     3        -1
   /   \     /   \
  2     1   4     5
       /   / \     \
      1   1   2     6
K = 5
Output:
8
Explanation:
The following paths sum to K.
3 2
3 1 1
1 3 1
4 1
1 -1 4 1
-1 4 2
5
1 -1 5
   */
    int possibles=0;
    public void ksum(Node root, Map<Integer,Integer> map, int k, int sum)
    {
        if(root==null)return ;

        //take current sum
        int tempsum=root.data+sum;

        //check sum -k in map if so add value

        if(map.containsKey(tempsum-k))possibles+=map.get(tempsum-k);
        //then put current key
        map.put(tempsum,map.getOrDefault(tempsum,0)+1);
        ksum(root.left,map,k,tempsum);
        ksum(root.right,map,k,tempsum);
        //remove from path
        map.put(tempsum,map.getOrDefault(tempsum,0)-1);
    }
    public int sumK(Node root,int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        ksum(root,map,k,0);
        return possibles;
    }
}
