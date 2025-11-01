package ArraysProblem;

import java.util.Arrays;

public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            // -4 and target is 2

            //5 -4 = 1
            //-4 3 = -1
            // for cloasest on left part look for element <= target
            //if lesser and  move right

            //if greater than target move left

            //for closest on right part look for element >=target

            // if greater move left

            //if smaller move right
            // [ 8 7 6  | 5 4 3 2 1 0 ]
            // -4 -1 1 2 target 1

            // -4 +2 = -2
            // left
            // -2 -1= -3
            // -2 +1 = -1  closest -5 -4  -4 5

            // 0 1 2 3 4 5


            // i can find the smallest number closest
            // i can find the larger number closest
            // among them which one is pretty closest will be my answer

            Arrays.sort(nums);
            int closest = Integer.MAX_VALUE,closestLength=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (i + 1 <= j - 1) {
                        int sum = nums[i] + nums[j];
                        int answer[]= binarySearch(i + 1, j - 1, sum, target, true,nums);
                        int leftClosest= answer[0];
                        int rightClosest = answer[1];
                        int tempClosest;
                        leftClosest=sum+leftClosest;
                        rightClosest=sum+rightClosest;
                        if((leftClosest>=0&&target<0)||(leftClosest<0&&target>=0)){
                            tempClosest = Math.abs(leftClosest) + Math.abs(target);
                        }else{
                            tempClosest = Math.abs(Math.abs(leftClosest) - Math.abs(target));

                        }
                        if(tempClosest<closestLength){
                            closestLength=tempClosest;
                            closest=leftClosest;
                        }
                        if((rightClosest>=0&&target<0)||(rightClosest<0&&target>=0)){
                            tempClosest = Math.abs(rightClosest) + Math.abs(target);
                        }else{
                            tempClosest = Math.abs(Math.abs(rightClosest) - Math.abs(target));

                        }
                        if(tempClosest<closestLength){
                            closestLength=tempClosest;
                            closest=rightClosest;
                        }

                    }

                }
            }
            return closest;
        }

        public int[] binarySearch(int start,int end,int sum,int target,boolean left,int []nums){
          //  int answer=left?Integer.MIN_VALUE+100000:Integer.MAX_VALUE-1000000;
            int answer[]={Integer.MIN_VALUE+100000,Integer.MAX_VALUE-1000000};
            while(start<=end){
                int mid=(start+end)>>1;
                if(nums[mid]+sum==target){
                    answer[0]=nums[mid];
                    answer[1]=nums[mid];
                    break;
                }else if (nums[mid]+sum<target){
                    answer[0]=nums[mid];
                    start=mid+1;
                }else{
                    answer[1]=nums[mid];
                    end=mid-1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution=new ThreeSumClosest().new Solution();
        int arr[]={-1,2,1,-4};
        System.out.println(solution.threeSumClosest(arr,1));
    }
}
