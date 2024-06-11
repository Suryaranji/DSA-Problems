package Slidingwindow;

import java.util.Arrays;

public class NumberOfSubstring {
    /**
     Given a string s consisting only of characters a, b and c.

     Return the number of substrings containing at least one occurrence of all these characters a, b and c.



     Example 1:

     Input: s = "abcabc"
     Output: 10
     Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
     Example 2:

     Input: s = "aaacb"
     Output: 3
     Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
     */
    public int numberOfSubstrings(String s) {

        int count=0;
        int charc[]=new int[3];
        Arrays.fill(charc,-1);
        for(int i=0;i<s.length();i++)
        {
            charc[s.charAt(i)-'a']=i;
            if(charc[0]!=-1&&charc[1]!=-1&&charc[2]!=-1)
            {
                //this line does this
                //eg : aabbc
                //there are two possibilities
                //one aabbc
                //next abbc
                //hence by adding minimum index value we get those possibilities
                count+=1+Math.min(Math.min(charc[0],charc[1]),charc[2]);
            }
        }
        return count;

    }
}
