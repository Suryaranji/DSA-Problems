package Recursion;

public class MoreSubsequences {
    public static int lengthofsequence(int index,String ans,String s)
    {
        if(index==s.length())return 1;
        int length=0;
        for(int i=index;i<s.length();i++)
        {
            if(i!=index&&s.charAt(i)==s.charAt(i-1))continue;
            length+=lengthofsequence(i+1, ans+s.charAt(i), s);
        }
        return length;
    }
    public static String moreSubsequence(int n, int m, String a, String b) {

        int length1=lengthofsequence(0,"",a);
        int length2=lengthofsequence(0,"",b);
        if(length1>=length2)
        {
            return a;
        }
        return b;

    }

}
