package Slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Maximumofwindow {


    /*
    *Approach :
      *Declare a deque which stores elements in a decreasing order not element it was index of elements
      *add element only if last elemet was greater else remove last element
      *remove indexes which is out of of bound of window

    Link:-https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1?page=1&category=sliding-window&sortBy=submissions
    */
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> answer=new ArrayList<>();
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            //remove out of bound elements
            while(!queue.isEmpty()&&i-queue.peekFirst()>=k)queue.removeFirst();
            // remove unwanted elements from subarray having lesser values
            while(!queue.isEmpty()&&arr[queue.peekLast()]<=arr[i])queue.removeLast();

            //add index last
            queue.addLast(i);
            if(i>=k-1)
            {
                answer.add(arr[queue.peekFirst()]);
            }
        }
        return answer;
    }
}
