package Trie.Implementation.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    Node  root=new Node();
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
    public void insert(String s){
        Node temp=root;
        for(char c:s.toCharArray()){
            if(temp.nodes[c-'a']==null){
                temp.nodes[c-'a']=new Node();
            }
            temp=temp.nodes[c-'a'];
        }
        temp.setEnd();
    }
    public boolean isStringExist(String s){
        Node temp=root;
        for(char c:s.toCharArray()){
            if(temp.nodes[c-'a']==null){
                return false;
            }
            temp=temp.nodes[c-'a'];
        }
        return temp.isEnd();
    }

    public void fillBoardWithMaxLength(char[][] board, int maxLength,int row,int col,Node root){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || maxLength<=0){
            return;
        }
        char c=board[row][col];
        if(c=='#'){
            return;
        }
        if (root.nodes[c - 'a'] == null) {
            root.nodes[c - 'a'] = new Node();
            root.nodes[c - 'a'].setEnd();
        }
        root=root.nodes[c-'a'];
        board[row][col]='#';
        fillBoardWithMaxLength(board,maxLength-1,row+1,col,root);
        fillBoardWithMaxLength(board,maxLength-1,row-1,col,root);
        fillBoardWithMaxLength(board,maxLength-1,row,col+1,root);
        fillBoardWithMaxLength(board,maxLength-1,row,col-1,root);
        board[row][col]=c;

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer=new ArrayList<>();
        /*int maxLength=0;
        for(String word:words){
            maxLength=Math.max(maxLength,word.length());
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                fillBoardWithMaxLength(board,maxLength,i,j,root);
            }
        }
        for(String word:words){
            if(isStringExist(word)){
                answer.add(word);
            }
        }*/
        Set<Character> startingChars=new HashSet<>();
        int maxLength=0;
        for(String word:words){
            maxLength=Math.max(maxLength,word.length());
        }
        for(String word:words){
            startingChars.add(word.charAt(0));
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!startingChars.contains(board[i][j])){
                    continue;
                }
                fillBoardWithMaxLength(board,maxLength,i,j,root);
            }
        }
        for(String word:words){
            if(isStringExist(word)){
                answer.add(word);
            }
            }
        return answer;

    }

    public static void main(String[] args) {
        WordSearchII obj=new WordSearchII();
        String[] words={"oath","pea","eat","rain"};
        char[][] board={
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        List<String> answer=obj.findWords(board,words);
        System.out.println(answer);

    }
}
