package Slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {
       /*
    S = "geeksforgeeks"
    Output:
    7
    Explanation:
    Longest substring is
    "eksforg".


    */

    int longestUniqueSubsttr(String S){

        Map<Character,Integer> map=new HashMap<>();
        int start=0,maximumLength=0;
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            //if map already contains check whether initial pointer greater if so then make the start as fro next of reeating char
            if(map.containsKey(c)&&map.get(c)>=start)
            {
                start=map.get(c)+1;
            }
            //update length if max
            maximumLength=Math.max(maximumLength,i-start+1);
            map.put(c,i);
        }
        return maximumLength;

    }
}
