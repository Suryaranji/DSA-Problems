package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfArraysOfMinimum {
    class Solution {
        public int sumSubarrayMins(int[] arr) {


            int n=arr.length;
            int sum=0;
            for(int i=1;i<=n;i++){

                int windowSize=i;
                int temp=0;
                Deque<Integer> deque=new ArrayDeque<>();
                while(temp<windowSize){
                    while(!deque.isEmpty() && arr[deque.peekLast()]>=arr[temp]){
                        deque.pollLast();
                    }
                    deque.offerLast(temp);
                    temp++;
                }
                sum+=arr[deque.peekFirst()];
                while(temp<n){
                    while(!deque.isEmpty() && deque.peekFirst()<=temp-windowSize){
                        deque.pollFirst();
                    }
                    while(!deque.isEmpty() && arr[deque.peekLast()]>=arr[temp]){
                        deque.pollLast();
                    }
                    deque.offerLast(temp);
                    sum=(sum+arr[deque.peekFirst()])%(1000000007);
                    temp++;
                }

            }
return  sum%(1000000007);
        }
    }

    public static void main(String[] args) {
        Solution solution=new SumOfArraysOfMinimum().new Solution();
        int arr[]={3,1,2,4};
        System.out.println(solution.sumSubarrayMins(arr));
    }
}
