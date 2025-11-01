package Trie.Implementation.problems;

public class Countofdistinctsubstrings {

    static Node root=new Node();

    static class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        public Node getNode(char c) {
            return nodes[c - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }



    public static int countDistinctSubstring(String st) {

        //generate explanation for the approach
        //the idea is to insert all the substrings of the given string in the trie and count the number of new nodes created during the insertion process
        //the number of new nodes created will be equal to the number of distinct substrings
        //we will also add 1 to the final count to account for the empty substring

        int answer = 0;
        Node temp;
        for (int i = 0; i < st.length(); i++) {
            temp=root;
            //aba
            for (int j = i; j < st.length(); j++) {
                char c=st.charAt(j);
                if (temp.nodes[c - 'a'] == null) {
                    temp.nodes[c - 'a'] = new Node();
                    answer++;

                }
                temp = temp.nodes[c - 'a'];
            }
        }
        root=new Node();
        return answer + 1;

    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstring("ababa"));
        System.out.println(countDistinctSubstring("abc"));
    }
}
