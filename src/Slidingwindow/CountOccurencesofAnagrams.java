package Slidingwindow;

public class CountOccurencesofAnagrams {
     /*
    Input:
    txt = forxxorfxdofr
    pat = for
    Output: 3
    Explanation: for, orf and ofr appears
    in the txt, hence answer is 3.
    https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1?page=1&category=sliding-window&sortBy=submissions

    Approach:
    .store pattern character occurences
    .find patterns by iterating from one to other
    .increment the index of string character
    .check whether that index is less than pattern index if so then increment count
    .if count equals pattern length then increment occurence
    .if i crosses pattern length then remove character from start
    .decrement count if the removed character is less than or equal to pattern character
    */

    int search(String pat, String txt) {
        int pattern[]=new int[256];
        int string[]=new int[256];

        //store pattern character occurences
        for(int i=0;i<pat.length();i++)
        {
            int index=(int)pat.charAt(i);
            pattern[index]++;
        }

        int numberOfOccurences=0,start=0,count=0;
        //find patterns by iterating from one to other
        for(int i=0;i<txt.length();i++)
        {
            int index=(int)txt.charAt(i);
            //increment the index of string character
            string[index]++;
            if(string[index]<=pattern[index])//check whether that index is less then pattern index if so then increment count
            {
                count++;
            }
            if(count==pat.length())// if count equals pattern length then increment occurence
            {

                numberOfOccurences++;
            }
            if(i>=pat.length()-1)
            {
                // if i crosses pattern length then remove character from start
                //decrement count if the removed character is less than or equal to pattern character
                count=string[(int)txt.charAt(start)]<=pattern[(int)txt.charAt(start)]?count-1:count;
                string[(int)txt.charAt(start)]--;
                start++;

            }
        }
        return numberOfOccurences;
    }
}
