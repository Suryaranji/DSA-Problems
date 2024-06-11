package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutation {

    public static String permute(int n,int k)
    {
        List<Integer> array=new ArrayList<>();
        int fact=1;
        for(int i=1;i<=n;i++)
        {
            array.add(i);
            fact*=i;
        }
        fact/=n;
        k-=1;//0 based indexing
        String answer ="";
        while(true)
        {
            //get each front number
            answer+=array.get(k/fact);
            //remove from number
            array.remove(k/fact);
            if(array.size()==0)break;//if all are finished just break
            k%=fact;//remaining permu
            fact/=array.size();// different possibles
        }
        return answer;
    }
}
