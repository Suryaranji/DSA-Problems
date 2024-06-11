package Slidingwindow;

public class SmallestWindow {
    /*
   Input : "GEEKSGEEKSFOR"
   Output : 8
   Explanation : Sub-string -> "GEEKSFOR"

   Expected Time Complexity: O(256.N)
   Expected Auxiliary Space: O(256)
   Approach:
   1)Loop to identify Distinct Characters in string Which takes O(N)  and Space O(256)Constan
   2)maintain current substring distinct characters;
   3)If newly visit a character then update count
   4)when count = distincount then
   5)move start until it char at start > 1 in visited array
   6)if so then decrement that and move start
   7)update answer if new length is minimum
   */
    public int findSubString( String str) {
        int distinctCount=0;
        int visitedArray[]=new int[256];
        //Loop to identify Distinct Characters in string Which takes O(N)  and Space O(256)Constant
        for(int i=0;i<str.length();i++)
        {
            if(visitedArray[(int)(str.charAt(i))]==0)
            {
                distinctCount++;
                visitedArray[(int)(str.charAt(i))]=1;
            }
        }
        //Loop that reinitialize old array values to zero
        for(int i=0;i<str.length();i++)
        {
            visitedArray[(int)(str.charAt(i))]=0;
        }
        //int  visitedArray[]=new int[256];
        int minimumLength=Integer.MAX_VALUE;//Declare answer as maximum value
        int start=0,end=0,count=0;//-> maintain current substring distinct characters;
        while(end<str.length())
        {

            int index=(int)str.charAt(end);
            //If newly visit a character then update count
            if(visitedArray[index]==0)
            {
                count++;
            }
            //Always Increment that character value
            visitedArray[index]++;
            //when count = distincount then
            if(distinctCount==count)
            {
                //move start until it char at start > 1 in visited array
                while(visitedArray[(int)str.charAt(start)]>1)
                {
                    //if so then decrement that and move start
                    visitedArray[(int)str.charAt(start)]--;
                    start++;

                }
                //System.out.println(str.substring(start,end+1));
                //update answer if new length is minimum
                minimumLength=Math.min(minimumLength,end-start+1);
            }
            end++;
        }
        return minimumLength;
    }
    /*
    S = "timetopractice"
    P = "toc"
    Output:
    toprac
    Explanation: "toprac" is the smallest
    substring in which "toc" can be found.

    Approach :
    Use two Hashmap to store frequencies of bot pattern and string


https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1?page=1&category=sliding-window&sortBy=submissions
    */
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int []pattern=new int[256];
        int []string=new int[256];
        if(s.length()<p.length())return "-1";
        for(int i=0;i<p.length();i++)
        {
            pattern[(int)p.charAt(i)]++;
        }
        int count=0,start=0;
        String minimumLength=null;
        for(int i=0;i<s.length();i++)
        {
            int index=(int)s.charAt(i);
            string[index]++;
            if(string[index]<=pattern[index])
            {
                //System.out.println(string[index]+" "+pattern[index]);

                count++;
            }
            if(count==p.length())
            {
                while(string[(int)s.charAt(start)]>pattern[(int)s.charAt(start)])
                {
                    string[(int)s.charAt(start)]--;
                    start++;
                }
                //System.out.println(s.substring(start,i+1));
                if(minimumLength==null||minimumLength.length()>i-start+1)
                {
                    minimumLength=s.substring(start,i+1);
                }

            }

        }
        if(minimumLength==null)
        {
            return "-1";
        }
        return minimumLength;
    }
}
