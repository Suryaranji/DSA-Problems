package Slidingwindow;

public class LongestCharReplacement {
    /*
    Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exist other ways to achieve this answer too.
*/
    public int characterReplacement(String s, int k) {
        int count=0;
        //to store the count of the array
        int[] map=new int[26];
        int start=0,finallength=0,maxelement=0;;
        for(int i=0;i<s.length();i++)
        {
            int windowlength=i-start+1;//the length of th might possible winow
            map[s.charAt(i)-'A']++;//increment the character count
            maxelement=Math.max(maxelement,map[s.charAt(i)-'A']);//if cuurent char count > max count then update
            //whenever the window length -maxelemnt > k then it indicates that window contains more no of distinct character

            while((i-start+1)-maxelement>k)
            {
                //System.out.print( map[s.charAt(start)-'A']+" ");
                //increment the front and reduce the count of char at front
                map[s.charAt(start)-'A']--;
                start++;
            }

            // update maxlength
            //System.out.println(s.substring(start,i+1));
            finallength=Math.max(finallength,i-start+1);
        }
        return finallength;
    }
}
