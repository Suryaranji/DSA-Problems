package Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingchar {
    /*
    Input: A = "aabc"
Output: "a#bb"
Explanation: For every ith character we will
consider the string from index 0 till index i first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - there are two non repeating characters 'b' and 'c',
first non-repeating character is 'b' because 'b' comes before
'c' in the stream
https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1?page=1&category=Queue&sortBy=submissions

     */
    public String FirstNonRepeating(String A)
    {
        Queue<Character> queue=new LinkedList<>();
        HashSet<Character> set=new HashSet<>();
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<A.length();i++)
        {
            char temp=A.charAt(i);
            if(set.contains(temp))
            {
                queue.remove(temp);
            }
            else
            {
                set.add(temp);
                queue.add(temp);
            }
            answer.append(queue.isEmpty()?'#':queue.peek());

        }
        return new String(answer);
    }
}
