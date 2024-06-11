package Tree.Construct;

import Tree.BinarySearch.Node;

import java.util.Stack;

public class BinaryTreefromPreOrder {
    /*
   Construct a binary tree of size N using two given arrays pre[] and preLN[]. Array pre[] represents preorder traversal of a binary tree. Array preLN[] has only two possible values L and N. The value L in preLN[] indicates that the corresponding node in Binary Tree is a leaf node and value N indicates that the corresponding node is a non-leaf node.
Note: Every node in the binary tree has either 0 or 2 children.

Example 1:

Input :
N = 5
pre[] = {10, 30, 20, 5, 15}
preLN[] = {N, N, L, L, L}

Output:
         10
       /    \
     30      15
    /  \
  20    5
   */
    Node constructTree(int n, int pre[], char preLN[]){
        Stack<Node> stack=new Stack<>();
        //track from back
        for(int i=n-1;i>=0;i--)
        {
            //if leaf push to stack
            if(preLN[i]=='L')
            {
                stack.push(new Node(pre[i]));
            }
            else
            {
                //if node then it have two leaves
                //pop from stack
                Node left=stack.pop();
                Node right=stack.pop();
                // make them as left and right
                Node newNode=new Node(pre[i]);
                newNode.left=left;
                newNode.right=right;
                //push that t stack
                stack.push(newNode);
            }
        }
        //return stack top
        return stack.pop();
    }
}
