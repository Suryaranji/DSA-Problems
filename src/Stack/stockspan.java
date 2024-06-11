package Stack;

import java.util.Stack;

public class stockspan {
    public static int[] calculateSpan(int price[], int n)
    {
        /*
        *Problem:
        *  The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days
        * just before the given day, for which the price of the stock on the given day is less than or equal to
        * its price on the current day.
        Input:
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
Explanation:
Traversing the given input span
100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
80 is greater than equal to 80 and smaller than 100 so the span is 1,
60 is greater than equal to 60 and smaller than 80 so the span is 1,
70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
60 is greater than equal to 60 and smaller than 70 so the span is 1,
75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6.
Hence the output will be 1 1 1 2 1 4 6.
For example,
* if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
* then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
*
* Approach:
* instead of backtracking values just store indexes
* check for previous values by peeking check for current price if smaller then pop
* else answer will be i+1 if stack is Empty()(No previous elements are larger else i-peek()

        https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1?page=1&category=Stack&sortBy=submissions

         */
        Stack<Integer> stack=new Stack<>();
        int answer[]=new int[n];
        answer[0]=1;
        stack.push(0);
        for(int i=1;i<n;i++)
        {

            while(!stack.isEmpty()&&price[i]>=price[stack.peek()])
            {
                stack.pop();
            }
            answer[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        return answer;

    }
}
