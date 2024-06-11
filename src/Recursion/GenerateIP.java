package Recursion;

import java.util.ArrayList;

public class GenerateIP {

    public void ipGen(String s, int index, int parts, ArrayList<String> answer, String ans)
    {

        //check if tht parttion is valid by ensuring it have 4 parts
        //and reaches the length
        if(index==s.length()&&parts==4)
        {
            //remove last dot
            answer.add(ans.substring(0,ans.length()-1));
            return ;
        }
        for(int i=index;i<index+3&&i<s.length();i++)
        {
            String toadd=s.substring(index,i+1);
            int number=Integer.parseInt(toadd);
            //check for non zero start or > 255
            if(number>255||(toadd.charAt(0)=='0'&&toadd.length()>1))return ;

            ipGen(s,i+1,parts+1,answer,ans+toadd+".");
        }


    }
    public ArrayList<String> genIp(String s) {
        ArrayList<String> answer=new ArrayList<>();
        if(s.length()<4||s.length()>12)
        {
            answer.add("-1");
            return answer;
        }
        ipGen(s,0,0,answer,"");
        return answer;
    }
}
