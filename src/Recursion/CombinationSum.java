package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void combination(List< List < Integer > >ans, List < Integer > temp,int []arr,int sum,int b,int index)
    {
        if(sum==b)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum>b||index==arr.length)
        {
            return;
        }
        temp.add(arr[index]);
        combination(ans,temp,arr,sum+arr[index],b,index);
        temp.remove(Integer.valueOf(arr[index]));
        combination(ans,temp,arr,sum,b,index+1);



    }
    public static List< List < Integer > > combSum(int []ARR, int B) {
        List< List < Integer > > ans=new ArrayList<>();
        Arrays.sort(ARR);
        combination(ans,new ArrayList<>(),ARR,0,B,0);
        return ans;
    }
}
