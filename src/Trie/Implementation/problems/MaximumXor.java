package Trie.Implementation.problems;

public class MaximumXor {
    class Solution {
        Node root;

        class Node {
            Node nodes[];

            Node() {
                nodes = new Node[2];
            }
        }

        public void store(int n) {
            Node temp = root;
            for (int i=31; i>=0; i--) {

                int ind = (n & (1 << i)) == 0 ? 0 : 1;
                if (temp.nodes[ind] == null) {
                    temp.nodes[ind] = new Node();
                }
                temp = temp.nodes[ind];
            }

        }

        public int getMaxCombination(int n) {
            Node temp = root;
            int ans = 0;
         for(int i=31;i>=0;i--){
            int ind = (n & (1 << i)) == 0 ? 0 :1;
            if(temp.nodes[1-ind]!=null){
                ans+=(1<<i);
                temp=temp.nodes[1-ind];
            }else {
                temp = temp.nodes[ind];
            }

         }
         return ans;
        }

        Solution() {
            root = new Node();
        }


        public int findMaximumXOR(int[] nums) {

            for(int i:nums){
                store(i);
            }

            int max = 0;
            for (int i : nums) {
                max = Math.max(getMaxCombination(i), max);
            }
            return max;

        }
    }

    public static void main(String[] args) {
        Solution solution = new MaximumXor().new Solution();
        System.out.println(solution.findMaximumXOR(new int[] { 25, 5 }));
    }
}
