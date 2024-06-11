package Recursion;

import java.util.ArrayList;

public class SubsetSmII {
    public static void subset(int []arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int index)

    {
        ans.add(new ArrayList<Integer>(temp));
        if(index==arr.length)return;
        for(int i=index;i<arr.length;i++)
        {
            if(i!=index&&arr[i]==arr[i-1])continue;
            temp.add(arr[i]);
            subset(arr, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void printSubsets(int input[]) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        subset(input, ans,temp, 0);
        for (ArrayList<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}
