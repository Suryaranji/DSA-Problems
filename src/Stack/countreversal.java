package Stack;

import java.util.Stack;

public class countreversal {
    /*
    @param s a string of curly braces   (}{{}}{{{)
    @ return the minimum  no of reversal needed to make it balanced (3)
    Approach:
    ->traverse the string if openBrack then push in stack
    ->else if stack is Empty then just pop()
           if Not then make reversal increase by one
      finally calculate the stack size and reversal increase by half of stack size

https://www.geeksforgeeks.org/problems/count-the-reversals0401/1?page=1&category=Queue&sortBy=submissions

     */

    int countRev (String s)
    {
        if(s.length()%2==1)return -1;
        Stack<Character> stack=new Stack<>();
        int reversals=0;
        for(int i=0;i<s.length();i++)
        {
            char bracket=s.charAt(i);
            if(bracket=='}')
            {
                if(!stack.isEmpty()&&stack.peek()=='{')stack.pop();
                else
                {
                    stack.push('}');

                }
            }
            else
            {
                stack.push('{');
            }

        }
        while(!stack.isEmpty())
        {
            if(stack.pop()==stack.pop())reversals+=1;
            else reversals+=2;
        }
        return reversals;
    }
}
