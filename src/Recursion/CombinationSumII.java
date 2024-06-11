package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {
    public static  void uniqueCombination( ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int index,int sum,ArrayList<Integer> arr,int k)
    {

        if(sum==k)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i=index;i<arr.size();i++)
        {
            if(i!=index&&arr.get(i)==arr.get(i-1))continue;
            temp.add(arr.get(i));
            uniqueCombination(ans,temp,i+1,sum+arr.get(i),arr,k);
            temp.remove(temp.size()-1);
        }

    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        uniqueCombination(ans,new ArrayList<Integer>(),0,0,arr,target);
        return ans;

    }
}
