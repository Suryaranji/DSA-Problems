package Recursion;

import java.util.Stack;

public class DecodeString {
    static String decodedString(String s){

        StringBuilder answer=new StringBuilder();
        Stack<String> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            //take that character
            char c=s.charAt(i);

            //check if it is  closing bracket
            if(c==']')
            {
                String tempString="";
                //pop until equals to closing bracket
                while(!stack.peek().equals("["))
                {
                    tempString=stack.pop()+tempString;
                }
                //remove that bracket
                stack.pop();
                //if stack not empty
                if(!stack.isEmpty())
                {
                    String number=stack.peek(); //check for numbers
                    if(Character.isDigit(number.charAt(0)))
                    {

                        int times=Integer.parseInt(number);
                        number=tempString;
                        //repeat string
                        while(times>1)
                        {
                            tempString+=number;
                            times--;
                        }
                        //pop number
                        stack.pop();
                    }

                }
                //push new string
                stack.push(tempString);

            }
            else
            {
                //check if previous is digit
                if(Character.isDigit(c))
                {
                    //concat that digit
                    String temp="";
                    if(!stack.isEmpty()&&Character.isDigit(stack.peek().charAt(0)))
                    {
                        temp+=stack.pop()+c;
                        stack.push(temp);
                        continue;
                    }
                }
                //push char


                stack.push(c+"");
            }

        }
        //until stack empty pop all elements
        while(!stack.isEmpty())
        {
            answer.insert(0,stack.pop());
        }
        return new String(answer);
    }
}
