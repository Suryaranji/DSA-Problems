package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void com(int K, int N, List<List<Integer>> ans, List<Integer> s, int in)
    {
        if(N==0&&s.size()==K)
        {
            ans.add(new ArrayList<>(s));
        }

        for(int i=in;i<=9;i++)
        {
            if(N-i>=0&&s.size()<K)
            {
                s.add(i);
                com(K,N-i,ans,s,i+1);
                s.remove(s.size()-1);
            }
            else
            {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>() ;
        com(k,n,ans,new ArrayList<>(),1);
        return ans;

    }
}
