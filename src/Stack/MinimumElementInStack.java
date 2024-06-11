package Stack;

import java.util.Stack;

public class MinimumElementInStack {

    /*
    Keeping track of min Element is critical two operations must be checked
    1)push-if(x<minEle) then push(2*x-minEle)
    make x as a new minElem 2)
    2)pop if(y<minEle) then return minEle and
    newmin=2*minEle-y

https://www.geeksforgeeks.org/problems/restrictive-candy-crush--141631/1?page=2&category=Stack&sortBy=submissions


     */
    int minEle;
    Stack<Integer> stack;

    // Constructor
    MinimumElementInStack()
    {
        stack=new Stack<>();
    }

    /*returns min element from stack*/
    int getMin()
    {
        if(stack.isEmpty())return -1;
        return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        if(stack.isEmpty())return -1;
        else
        {
            if(stack.peek()<minEle)
            {
                int temp=minEle;
                minEle=2*minEle-stack.pop();
                return temp;
            }
            return stack.pop();

        }
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(stack.isEmpty())
        {
            stack.push(x);
            minEle=x;
        }
        else
        {
            if(x<minEle)
            {
                stack.push(2*x-minEle);
                minEle=x;
            }
            else
            {
                stack.push(x);
            }
        }
    }
}
