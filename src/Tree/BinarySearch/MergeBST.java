package Tree.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeBST {
    /*
    Given two BSTs, return elements of both BSTs in sorted form.


Example 1:

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation:
After merging and sorting the
two BST we get 1 2 2 3 3 4 5 6 6 7.
Example 2:

Input:
BST1:
       12
     /
    9
   / \
  6   11
BST2:
      8
    /  \
   5    10
  /
 2
Output: 2 5 6 8 9 10 11 12
Explanation:
After merging and sorting the
two BST we get 2 5 6 8 9 10 11 12.
    */
    //Function to return a list of integers denoting the node
    //values of both the BST in a sorted order.
    public void inorder(Node root, Stack<Node> stack)
    {
        if(root==null)return;
        stack.push(root);
        inorder(root.left, stack);


    }
    public List<Integer> merge(Node root1, Node root2)
    {
        List<Integer> answer=new ArrayList<>();
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        //do inorder traversal to keep track of smallest element at the end noth stack top contains smallee element in each trees
        inorder(root1,stack1);
        inorder(root2,stack2);

        while(!stack1.isEmpty()&&!stack2.isEmpty())
        {
            //remove smaller add to answer and call inorder if right vice versa for all
            if(stack1.peek().data<stack2.peek().data)
            {
                answer.add(stack1.peek().data);
                inorder(stack1.pop().right,stack1);
            }
            else if(stack1.peek().data>stack2.peek().data)
            {
                answer.add(stack2.peek().data);
                inorder(stack2.pop().right,stack2);
            }
            else
            {
                answer.add(stack1.peek().data);
                answer.add(stack2.peek().data);
                inorder(stack1.pop().right,stack1);
                inorder(stack2.pop().right,stack2);

            }
        }
        while(!stack1.isEmpty())
        {
            answer.add(stack1.peek().data);
            inorder(stack1.pop().right,stack1);

        }
        while(!stack2.isEmpty())
        {
            answer.add(stack2.peek().data);
            inorder(stack2.pop().right,stack2);

        }


        return answer;

    }
}
