package Graphs.ShortestDistance;

import java.util.*;

public class WordLadderII {

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        //set to keep track of already visited strings and existence
        Set<String> set=new HashSet<String>();
        for(String i:wordList)
        {
            set.add(i);
        }
        //add queue start and remove from set
        Queue<ArrayList<String>> queue=new LinkedList<>();
        ArrayList<String> temp=new ArrayList<>();
        temp.add(startWord);
        queue.add(temp);
        ArrayList<ArrayList<String>> answer=new ArrayList<ArrayList<String>>();
        ArrayList<String> wordstoremove=new ArrayList<>();
        wordstoremove.add(startWord);

        int level=0;
        while(!queue.isEmpty())
        {
            temp=queue.remove();
            if(level<temp.size())
            {
                level++;
                for( String i : wordstoremove)
                {

                    set.remove(i);
                }
            }

            String last=temp.get(temp.size()-1);
            if(last.equals(targetWord))
            {
                if(answer.size()==0||answer.get(0).size()==temp.size())answer.add(temp);
                else break;
            }


            char str[]=temp.get(temp.size()-1).toCharArray();
            for(int i=0;i<str.length;i++)
            {
                for(char j='a';j<='z';j++)
                {
                    char tempchar=str[i];
                    str[i]=j;
                    String modified=new String(str);
                    if(set.contains(modified))
                    {
                        temp.add(modified);
                        ArrayList<String> newtemp=new ArrayList<>(temp);
                        wordstoremove.add(modified);
                        queue.add(newtemp);
                        temp.remove(temp.size()-1);
                    }
                    str[i]=tempchar;
                }
            }
        }
        return answer;
    }
}
