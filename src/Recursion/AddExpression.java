package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AddExpression {
    public void combinations(String num, int target, String temp, long number, long previous, List<String> answer, int index)
    {


        if(index==num.length())
        {
            //check if equals target
            if(number==target)
            {
                answer.add(temp);
            }
            return ;
        }
        for(int i=index;i<num.length();i++)
        {
            //check for valid number
            String tempString=num.substring(index,i+1);
            long tempnumber=Long.parseLong(tempString);
            //if not 012-> return
            if(tempString.charAt(0)=='0'&&tempString.length()>1)return;
            //index== 0then dont add any operators previously
            if(index==0)
            {
                combinations(num,target,temp+tempString,tempnumber,tempnumber,answer,i+1);
            }
            else {
                //add all possiblities and store previous number
                combinations(num, target, temp + "+" + tempString, number + tempnumber, tempnumber, answer, i + 1);
                combinations(num, target, temp + "-" + tempString, number - tempnumber, -tempnumber, answer, i + 1);
                // System.out.println(temp+"*"+tempString+" "+(number-previous+(previous*tempnumber))+ " "+(previous*tempnumber));
                //if multiplication then remove previous and multiply with new then add then previous is multplied
                combinations(num, target, temp + "*" + tempString, number - previous + (previous * tempnumber), previous * tempnumber, answer, i + 1);
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        List<String> answer=new ArrayList<String>();

        combinations(num,target,"",0,0,answer,0);
        return answer;
    }
}
