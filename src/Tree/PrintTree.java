package Tree;

import java.util.*;

class BinaryTreePrinter {
    static final int COUNT = 10;
    static class TreeNode {
        String val;
        TreeNode left, right;

        TreeNode(String val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void printTree(String[] arr) {
        if (arr == null || arr.length == 0 || arr[0].equals("n")) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            // Left child
            if (!arr[i].equals("n")) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && !arr[i].equals("n")) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        print2D(root);
    }

    static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        if(!root.val.equals("N"))
          System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public static void main(String[] args) {
        // Example usage
        String qn="1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N";
        String[] arr = qn.split("\\s");
        printTree(arr);
    }
}

