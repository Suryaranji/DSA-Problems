package Stack;

import java.util.Stack;
class Pair{
    char c;
    int count;
    Pair(char c,int count)
    {
        this.c=c;
        this.count=count;
    }
}
public class RestrictiveCandyCrush {


    /*
    *@param k indicates number of consecutive characters to be removed
    *@param s the string to reduce
    *@return the reduced string
    * Approach:
    * if k equal 1 then every character has to be removed
    * else make a stack which holds a character and that count
    * traverse through the string update if stack top equals upcoming character then update count
    * if count equals k then just remove k elements from stack
    * else just push character to stack
    * finally remove each character from stack and update answer
    * then reverse string and return
     */
        public static String reduced_String(int k, String s)
        {
            if(k==1)return "";
            Stack<Pair> stack=new Stack<>();
            for(int i=0;i<s.length();i++)
            {
                char temp=s.charAt(i);
                if(!stack.isEmpty())
                {
                    temp=s.charAt(i);
                    if(stack.peek().c==temp)
                    {
                        int count=stack.peek().count+1;
                        stack.push(new Pair(temp,count));
                        if(count==k)
                        {
                            while(count>0)
                            {
                                stack.pop();
                                count--;
                            }
                        }
                    }
                    else
                    {
                        stack.push(new Pair(temp,1));
                    }
                }
                else
                    stack.push(new Pair(temp,1));

            }
            StringBuilder answer=new StringBuilder();
            while(!stack.isEmpty())
            {
                answer.append(stack.pop().c);
            }
            return new String(answer.reverse());

        }

}
