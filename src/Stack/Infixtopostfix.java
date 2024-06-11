package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Infixtopostfix {
    /*
    Problem:
    Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

      Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
     Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
    Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right associativity of ^.

    Input: str = "a+b*(c^d-e)^(f+g*h)-i"
    Output: abcd^e-fgh*+^*+i-
    Approach:The approch for this problem will be simple the operands need to be on left and operators
    should be on right look Cases for () and pecedence like +=-<*=/<^



     */
    public static String infixToPostfix(String exp) {
        Map<Character,Integer> precedence=new HashMap<>();
        precedence.put('+',0);
        precedence.put('-',0);
        precedence.put('*',1);
        precedence.put('/',1);
        precedence.put('^',2);
        precedence.put('(',-1);
        precedence.put(')',-1);
        Stack<Character> stack=new Stack<>();
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(!precedence.containsKey(c))answer.append(c);
            else
            {
                if(stack.isEmpty())stack.push(c);
                else if(c=='(')stack.push(c);
                else if(c==')')
                {
                    while(!stack.isEmpty()&&stack.peek()!='(')
                    {
                        answer.append(stack.pop());
                    }
                    stack.pop();
                }
                else
                {
                    while(!stack.isEmpty()&&precedence.get(stack.peek())>=precedence.get(c))
                    {
                        answer.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty())
        {
            answer.append(stack.pop());
        }
        return new String(answer);
    }
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(Character.isDigit(c))
            {
                stack.push(Character.getNumericValue(c));
            }
            else
            {
                int second=stack.pop();
                int first=stack.pop();
                int answer=0;
                switch(c)
                {
                    case '+':
                        answer=first+second;
                        break;
                    case '-':
                        answer=first-second;
                        break;
                    case '*':
                        answer=first*second;
                        break;
                    case '/':
                        answer=first/second;
                        break;
                }
                stack.push(answer);
            }
        }
        return stack.pop();
    }
    public static String prefixtopostfix(String s)
    {
        String answer="";
        Stack<String> stack=new Stack<>();
        String operator="+/*-";
        for(int i=s.length()-1;i>=0;i--)
        {
            String c=s.charAt(i)+"";
            if(operator.contains(c))
            {
                String temp=stack.pop()+stack.pop()+c;
                stack.push(temp);
            }
            else
            {
                stack.push(c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(prefixtopostfix("*+AB-CD"));
    }
}
