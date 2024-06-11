package Tree;

public class MIinDISTANCE {
    /*
   Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.

Example 1:

Input:
       1
     /  \
    2    3
a = 2, b = 3
Output:
2
Explanation:
We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2.
Example 2:

Input:
       11
     /   \
    22  33
   /  \  /  \
 44 55 66 77
a = 77, b = 22
Output:
3
Explanation:
We need the distance between 77 and 22. Being at node 77, we need to take three steps ahead in order to reach node 22. The path followed will be: 77 -> 33 -> 11 -> 22. Hence, the result is 3.
   */
    int minDistance=Integer.MAX_VALUE;
    int find(Node root,int a,int b)
    {
        if(root==null)return 0;
        int left=find(root.left,a,b);
        int right=find(root.right,a,b);
        //if left and right part contains nodes
        //then this node is answer and add distance
        if(left!=0&&right!=0)
        {
            minDistance=left+right;
            return 0;
        }
        //if any  part has one node and current other node is root
        //update distance
        if((left!=0||right!=0)&&(root.data==a||root.data==b))
        {
            minDistance=left==0?right:left;
            return 0;
        }
        // if current node contains has any node then return 1
        if(root.data==a||root.data==b)
        {
            return 1;
        }
        // if any part has any node then return distance +1
        return left+right==0?0:left+right+1;

    }
    int findDist(Node root, int a, int b) {
        if(a==b)return 0;
        find(root,a,b);
        return minDistance;

    }
}
