package Recursion;

import java.util.*;

public class UniquePermutation {

    public void permute(int nums[],int index,List<List<Integer>> answer)
    {
        if(index==nums.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i:nums)temp.add(i);
            answer.add(temp);
            return ;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++)
        {
            if(set.contains(nums[i]))continue;//this checks if current is equal to any  previous elements to avoid duplicate
            set.add(nums[i]);
            int temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
            permute(nums,index+1,answer);
            temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer=new ArrayList<>();
        permute(nums,0,answer);

        // System.out.println(answer);
        return answer;

    }

    public static void main(String[] args) {
        int arr[]={0,0,1,9};
        UniquePermutation uniquePermutation=new UniquePermutation();
        uniquePermutation.permuteUnique(arr);

    }
}
