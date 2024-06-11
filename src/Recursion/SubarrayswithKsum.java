package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarrayswithKsum {
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {

        HashMap<Long,Integer> map =new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        long sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
            map.put(sum,i);
            if((!map.isEmpty()&&map.containsKey(sum-k))||sum==k)
            {
                int start=map.containsKey(sum-k)?map.get(sum-k)+1:0;
                List<Integer> temp=new ArrayList<>();
                for(int j=start;j<=i;j++)
                {
                    temp.add(a[j]);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
