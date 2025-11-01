package Trie.Implementation.problems;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    class Solution {
        Node root;
        class Node{
            Node[] nodes;
            boolean isEnd;
            Node(){
                nodes=new Node[26];
            }
            public Node getNode(char c){
                return nodes[c-'a'];
            }
            public boolean isEnd(){
                return isEnd;
            }
            public void setEnd(){
                isEnd=true;
            }
        }


        public Solution() {
            root=new Node();

        }

        public void addWord(String word) {
            Node temp=root;
            for(char c:word.toCharArray()){
                if(temp.nodes[c-'a']==null){
                    temp.nodes[c-'a']=new Node();
                }
                temp=temp.nodes[c-'a'];
            }
            temp.setEnd();

        }

        public String search(String word) {
            Node temp=root;
            int charMatched=0;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(temp.nodes[c-'a']==null){
                    charMatched=0;
                    break;
                }
                if(temp.nodes[c-'a'].isEnd()){
                    charMatched++;
                    break;
                }
                temp=temp.nodes[c-'a'];
                charMatched++;
            }
            return charMatched==0?word:word.substring(0,charMatched);


        }
        public String replaceWords(List<String> dictionary, String sentence) {
            for(String s:dictionary){
                addWord(s);
            }
            String []split=sentence.split(" ");
            StringBuilder answer=new StringBuilder();
            for(String s:split){
                answer.append(search(s));
                answer.append(" ");


            }
            return answer.toString().trim();

        }
    }

    public static void main(String[] args) {
        Solution solution=new ReplaceWords().new Solution();
        System.out.println(solution.replaceWords(Arrays.asList("cat","bat","rat"),"the cattle was rattled by the battery"));

        System.out.println( );
        StringBuilder sb = new StringBuilder();
        int n=5;
        String binary = Integer.toBinaryString(n);
        int padding = 32 - binary.length();
        for (int i = 0; i < padding; i++) {
            sb.append('0');
        }
        sb.append(binary);
        String s = sb.toString();
        System.out.println(s);
        System.out.println(s.length());

        int index=32;
        int refromedNumber=0;
        for(int i=0;i<s.length();i++){
            index--;
            if(s.charAt(i)=='1') {
                refromedNumber += (int) Math.pow(2, index);
            }

        }
        System.out.println(refromedNumber);
        System.out.println(refromedNumber==n);

    }
}
