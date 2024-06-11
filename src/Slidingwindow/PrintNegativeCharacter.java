package Slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNegativeCharacter {
    /*
    *
    * @param arr,N,k determines long array ,size of array, window size
    * @return long array returns first negative characters from that specified window
    * Approach
    * use q  to store negative numbers
    * if window breached remove if front element and peek of q equal
    *
     */
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        Queue<Long> negative=new LinkedList<>();
        long []answer=new long[N-K+1];
        int temp=0;
        int count=0;
        for(int i=0;i<N;i++)
        {
            count++;
            if(arr[i]<0)
            {
                negative.add(arr[i]);
            }
            if(count==K)
            {
                answer[temp++]=negative.isEmpty()?0:negative.peek();
                if(!negative.isEmpty()&&negative.peek()==arr[i-K+1])
                {
                    negative.remove();
                }
                count--;
            }
        }
        return answer;
    }
}
