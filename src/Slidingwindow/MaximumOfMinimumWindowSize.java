package Slidingwindow;

import java.util.Stack;

public class MaximumOfMinimumWindowSize {
    /*
    Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10
Explanation:
1.First element in output
indicates maximum of minimums of all
windows of size 1.
2.Minimums of windows of size 1 are {10},
 {20}, {30}, {50},{10}, {70} and {30}.
 Maximum of these minimums is 70.
3. Second element in output indicates
maximum of minimums of all windows of
size 2.
4. Minimums of windows of size 2
are {10}, {20}, {30}, {10}, {10}, and
{30}.
5. Maximum of these minimums is 30
Third element in output indicates
maximum of minimums of all windows of
size 3.
6. Minimums of windows of size 3
are {10}, {20}, {10}, {10} and {10}.
7.Maximum of these minimums is 20.
Similarly other elements of output are
computed.
     */
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n)
    {

        Stack<Integer> stack=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++)
        {
            left[i]=-1;
            right[i]=n;
        }

        //find left smaller of every element
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty()&&arr[i]<=arr[stack.peek()])stack.pop();
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        // System.out.println(Arrays.toString(left));
        while(!stack.isEmpty())stack.pop();
        //find right smaller of every element
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&arr[i]<=arr[stack.peek()])stack.pop();
            right[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        //System.out.println(Arrays.toString(right));
        int answer[]=new int[n+1];
        //distance between each element is updated inn array
        for(int i=0;i<n;i++)
        {
            int len=right[i]-left[i]-1;
            //answer may be max of new vs old
            answer[len]=Math.max(answer[len],arr[i]);
        }
        int result[]=new int[n];
        //fill if there are are any missing values from right
        for(int i=n-1;i>=1;i--)
        {
            answer[i]=Math.max(answer[i],answer[i+1]);
        }
        //update answer result
        for(int i=1;i<=n;i++)
        {
            result[i-1]=answer[i];
        }

        return result;

    }
}
