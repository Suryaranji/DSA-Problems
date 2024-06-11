package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n)
    {

        /*
        *Input=[6 8 0 1 3]
        * output=[8 -1 1 3 -1]
        *
        * Approach Using Stack
        * if(stack is Empty) then greater will be -1;
        * else
        * pop() stack until it is greater if not return -1
        * if there then make as greater push new element
        *
        *
        * Time Complexity=O(N)
        * Space Complexity=O(N)
        *
         */
        Stack<Long> stack=new Stack<>();
        long[] answer =new long[n];
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                answer[i]=-1;
                stack.push(arr[i]);
            }
            else
            {
                while(!stack.isEmpty()&&arr[i]>=stack.peek())
                {
                    stack.pop();

                }
                if(!stack.isEmpty())
                {
                    answer[i]=stack.peek();
                }
                else
                {
                    answer[i]=-1;
                }
                stack.push(arr[i]);
            }
        }
        return answer;
    }
    public int[] nextGreaterElementsII(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int answer[]=new int[arr.length];
        for(int i=n-2;i>=0;i--)
        {
            stack.push(arr[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                answer[i]=-1;
                stack.push(arr[i]);
            }
            else
            {
                while(!stack.isEmpty()&&arr[i]>=stack.peek())
                {
                    stack.pop();

                }
                if(!stack.isEmpty())
                {
                    answer[i]=stack.peek();
                }
                else
                {
                    answer[i]=-1;
                }
                stack.push(arr[i]);
            }
        }
        return answer;

    }
}
