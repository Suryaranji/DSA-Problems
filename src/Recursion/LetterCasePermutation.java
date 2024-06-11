package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /*
    Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
     */
    public void possibles(String s, String temp, List<String> answer, int index)
    {
        if(temp.length()==s.length())
        {
            answer.add(new String(temp));
            return ;
        }
        char c=s.charAt(index);
        //return usual
        possibles(s,temp+c,answer,index+1);
        if(Character.isAlphabetic(c))
        {
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c); // Convert to uppercase
            }
            else if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c); // Convert to lowercase
            }
            //next pass to only changes
            possibles(s,temp+c,answer,index+1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> answer=new ArrayList<>();
        possibles(s,"",answer,0);
        return answer;

    }
}
