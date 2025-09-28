package BitManipulation;

import java.util.ArrayList;
import java.util.List;

class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        //why this works
        //a set can generate 2^n subsets where n is the number of elements in the set
        //we can represent each subset by a binary number of n bits where each bit represents whether
        //the corresponding element is present in the subset or not
        //for example if we have a set {1,2,3} then the subsets
        //000 -> {}
        //001 -> {1}
        //010 -> {2}
        //011 -> {1,2}
        //100 -> {3}
        //101 -> {1,3}
        //110 -> {2,3}
        //111 -> {1,2,3}
        //we can generate all the subsets by iterating from 0 to 2^n-1 and for each number we can check which bits are set
        //if the jth bit is set then we can include the jth element in the subset
        List<List<Integer>> answer=new ArrayList<>();
        for(int i=0;i<Math.pow(2,nums.length);i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(((i>>j)&1)==1){
                    temp.add(nums[j]);
                }
            }
            answer.add(temp);
        }
        return answer;

    }

    public static void main(String[] args) {
        PowerSet ps=new PowerSet();
        int arr[]=new int[]{1,2,3};
        System.out.println(ps.subsets(arr));
    }
}