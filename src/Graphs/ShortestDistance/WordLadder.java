package Graphs.ShortestDistance;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    /*
   Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0


Example 1:

Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".
   */
    class Pair{
        String s;
        int steps;
        Pair(String s,int steps)
        {
            this.s=s;
            this.steps=steps;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        //set to keep track of already visited strings and existence
        Set<String> set=new HashSet<String>();
        for(String i:wordList)
        {
            set.add(i);
        }
        //add queue start and remove from set
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(startWord,1));
        set.remove(startWord);
        while(!queue.isEmpty())
        {
            Pair temp=queue.remove();
            //System.out.println("removed from queue "+temp.s);

            if(temp.s.equals(targetWord))
            {
                return temp.steps;
            }
            //traverse each char of new word and make all possible words from set
            // add them to queue and remove from set
            char str[]=temp.s.toCharArray();
            for(int i=0;i<str.length;i++)
            {
                for(char j='a';j<='z';j++)
                {
                    char tempchar=str[i];
                    str[i]=j;
                    String modified=new String(str);
                    if(set.contains(modified))
                    {
                        // System.out.println(modified);
                        set.remove(modified);
                        queue.add(new Pair(modified,temp.steps+1));
                    }
                    str[i]=tempchar;
                }
            }
        }
        return 0;
    }
}
