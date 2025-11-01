package Trie.Implementation.problems;

public class LongestValidWordWithAllPrefixes {

    class Node {
        Node links[];
        boolean flag;
        int prefixCount;

        Node() {
            links = new Node[26];
            flag = false;
            prefixCount += 1;
        }

        boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        Node get(char c) {
            return links[c - 'a'];
        }

        void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }

    public void insert(String s, Node root) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!temp.containsKey(c)) {
                temp.put(c, new Node());
            } else {
                temp.get(c).prefixCount++;
            }
            temp = temp.get(c);
        }
        temp.setEnd();
    }

    public String longestWord(String[] words) {
        Node root = new Node();
        for (String s : words) {
            insert(s, root);
        }
        String longest = "";
        for (String s : words) {
            Node temp = root;
            boolean valid = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!temp.get(c).isEnd()) {
                    valid = false;
                    break;
                }
                temp = temp.get(c);
            }
            if (valid) {
                if (s.length() > longest.length() || (s.length() == longest.length() && s.compareTo(longest) < 0)) {
                    longest = s;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidWordWithAllPrefixes obj = new LongestValidWordWithAllPrefixes();
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        //String words[] = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
         //String words[] = {"a", "b", "c", "ab", "bc", "abc"};
        System.out.println(obj.longestWord(words));
    }
}
