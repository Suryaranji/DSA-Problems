package Slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindow {

    /*
    *@param arr have elements ;
    *@param k,n size of window and array
    *@return arraylist of distinct elements of each window
    *
    * Approach
    * use hashmap to store each distinct elements and add count
    * if window size reaches then update answerlist
    * then remove front value one by one
     */
        ArrayList<Integer> countDistinct(int arr[], int n, int k)
        {
            ArrayList<Integer> answer=new ArrayList<Integer>();
            HashMap<Integer,Integer> map=new HashMap<>();
            int count=0;
            for(int i=0;i<n;i++)
            {
                count++;
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if(count==k)
                {

                    answer.add(map.size());
                    if(map.containsKey(arr[(i-k)+1]))
                    {
                        if(map.get(arr[(i-k)+1])==1)
                        {

                            map.remove(arr[(i-k)+1]);

                        }
                        else
                        {

                            map.put(arr[(i-k)+1],map.get(arr[(i-k)+1])-1);

                        }
                    }
                    count--;
                }

            }

            return answer;
        }
    static int countOfSubstrings(String S, int K) {
        // map stores character and their count of occurence in that windoow
        Map<Character,Integer> map=new HashMap<>();
        int answer=0;
        for(int i=0;i<S.length();i++)
        {
            char temp=S.charAt(i);
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(i>=K-1)
            {
                //System.out.println(map);
                if(map.size()==K-1)
                {
                    answer++;
                }
                if(map.get(S.charAt(i-K+1))==1)map.remove(S.charAt(i-K+1));
                else
                {
                    map.put(S.charAt(i-K+1),map.get(S.charAt(i-K+1))-1);
                }
            }

        }
        return answer;
    }
    //Alternate solution with constant space
    int countOfSubstrings2(String S, int K) {

        int ans = 0, dist = 0, n = S.length();
        // Array to store the frequency of each character in the substring
        int[] fre = new int[26];
        for(int i = 0; i < K; i++)
        {
            // Increment the frequency of the character at index i in the string S
            fre[S.charAt(i)-'a']++;
            // If the frequency is 1, it means a new distinct character is added to the substring
            if(fre[S.charAt(i)-'a']==1)
                dist++;
        }

        // If the count of distinct characters in the substring is equal to K-1, increment the answer
        if(dist==K-1)
            ans++;

        for(int i = K; i < n; i++)
        {
            // Decrement the frequency of the character that is going out of the window
            fre[S.charAt(i-K)-'a']--;
            // If the frequency becomes 0, it means that the distinct character count is decreased
            if(fre[S.charAt(i-K)-'a']==0)
                dist--;
            // Increment the frequency of the character that is coming into the window
            fre[S.charAt(i)-'a']++;
            // If the frequency is 1, it means a new distinct character is added to the substring
            if(fre[S.charAt(i)-'a']==1)
                dist++;

            // If the count of distinct characters in the substring is equal to K-1, increment the answer
            if(dist==K-1)
                ans++;
        }

        // Return the final count of substrings with K distinct characters
        return ans;
    }
    }

