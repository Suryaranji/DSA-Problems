package Recursion;

import java.util.ArrayList;

public class PossibleWords {
    //Function to find list of all words possible by pressing given numbers.
    static void permute(int a[], String numbers[], String answer, int arrindex, int stringindex, ArrayList<String> answers)
    {
        //once answer length same as array length then store string
        if(answer.length()==a.length)
        {
            answers.add(new String(answer));
            return ;
        }
        //start from arrindex to last
        for(int i=arrindex;i<a.length;i++)
        {
            //traverse each char
            for(int j=stringindex;j<numbers[a[i]].length();j++)
            {
                char c=numbers[a[i]].charAt(j);
                //look for next arrindex
                permute(a,numbers,answer+c,i+1,0,answers);
            }
        }
    }
    static ArrayList <String> possibleWords(int a[], int N)
    {
        String arr[]={"0","0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> answers=new ArrayList<>();
        permute(a,arr,"",0,0,answers);
        return answers;

    }
}
