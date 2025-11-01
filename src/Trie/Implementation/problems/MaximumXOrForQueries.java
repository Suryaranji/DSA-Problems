package Trie.Implementation.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumXOrForQueries {

    Node root;

    class Node {
        Node nodes[];

        Node() {
            nodes = new Node[2];
        }
    }

    public void store(int n) {
        Node temp = root;
        for (int i = 31; i >= 0; i--) {

            int ind = (n & (1 << i)) == 0 ? 0 : 1;
            if (temp.nodes[ind] == null) {
                temp.nodes[ind] = new Node();
            }
            temp = temp.nodes[ind];
        }

    }

    public int getMaxCombination(int n, Node root) {
        Node temp = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int ind = (n & (1 << i)) == 0 ? 0 : 1;
            if (temp.nodes[1 - ind] != null) {
                ans |= (1 << i);
                temp = temp.nodes[1 - ind];
            } else {
                temp = temp.nodes[ind];
            }

        }
        return ans;
    }

    public boolean containsKey(Node temp, int n) {
        return temp.nodes[n] != null;
    }

    MaximumXOrForQueries() {
        root = new Node();
    }

    class IndexPair {
        int index;
        int[] array;

        IndexPair(int index, int[] array) {
            this.array = array;
            this.index = index;
        }

        @Override
        public String toString() {
            return "IndexPair{" + "index=" + index + ", array=" + Arrays.toString(array) + '}';
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);
        List<IndexPair> newQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            newQueries.add(new IndexPair(i, queries[i]));
        }
        newQueries.sort(Comparator.comparingInt(a -> a.array[1]));

        System.out.println(newQueries);
        int answer[] = new int[queries.length];
        int indexStored = 0;
        int i;
        for (i = 0; i < queries.length; i++) {
            int xi = newQueries.get(i).array[0];
            int mi = newQueries.get(i).array[1];
            while (indexStored < nums.length && nums[indexStored] <= mi) {
                if(i == 0 || nums[i] != nums[i - 1]) {
                    store(nums[indexStored]);
                }
                indexStored++;
            }
            if(indexStored!=0){
                answer[newQueries.get(i).index] = getMaxCombination(xi, root);
            }else{
                answer[newQueries.get(i).index]=-1;
            }



        }

        return answer;

    }

    public static void main(String[] args) {
        MaximumXOrForQueries m = new MaximumXOrForQueries();
        int[] nums = { 818702963, 153655392, 4096, 917434814, 4096 };
        int[][] queries = { { 11886620, 881210474 }, { 811373, 1000000000 }, { 20352316, 1000000000 },
                { 443746890, 860009574 }, { 872954994, 1000000000 } };
        System.out.println(Arrays.toString(m.maximizeXor(nums, queries)));

    }
}
