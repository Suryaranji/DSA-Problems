package Tree.Construct;

import java.util.ArrayList;

public class SerializeDeserialize {
    /*
  Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.
Note: The structure of the tree must be maintained. Multiple nodes can have the same data.
Note : NULL is denoted by -1.

Example 1:

Input:
    1
  /   \
 2     3
Output: 2 1 3
Example 2:

Input:
       10
     /    \
    20    30
  /   \
 40  60
Output: 40 20 60 10 30
  */
    //Function to serialize a tree and return a list containing nodes of tree.

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }

        public void serialize(Node root, ArrayList<Integer> A) {
            if (root == null) {
                //null indicates that it dont have child then we push -1
                A.add(-1);
                return;
            }
            A.add(root.data);
            serialize(root.left, A);
            serialize(root.right, A);

        }

        public Node des(ArrayList<Integer> a) {
            if (a.size() == 0) return null;
            Node root = null;
            int data = a.remove(0);
            if (data == -1) {
                // if data -1 then it null
                return root;
            }
            root = new Node(data);

            root.left = des(a);
            root.right = des(a);

            return root;
        }

        //Function to deserialize a list and construct the tree.
        public Node deSerialize(ArrayList<Integer> A) {
            return des(A);
        }
    }
}
