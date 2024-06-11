package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsetsum {
    public static void subset(int arr[], ArrayList<Integer> ans, int k, int index)
    {
        if(index==arr.length){
            ans.add(k);
            return;
        }

        subset(arr,ans,k+arr[index],index+1);
        subset(arr,ans,k,index+1);


    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        subset(num,ans,0,0);
        Collections.sort(ans);
        return ans;
    }
}
