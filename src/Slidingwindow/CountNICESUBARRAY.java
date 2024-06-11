package Slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountNICESUBARRAY {
    /*
  Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
  Output: 16
  Input: nums = [1,1,2,1,1], k = 3
  Output: 2
  Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
  Approach:
  transform as k sum by  taking odd element as 1 and even as zero
  if sum equals k then it is a subarray increment cou
  if there are any prefix sum then just add that count
  add count of sum in map

  */
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,subarrayCount=0;
        for(int i:nums)
        {
            //transform as k sum by  taking odd element as 1 and even as zero
            sum+=i%2==0?0:1;
            //if sum equals k then it is a subarray increment count
            if(sum==k)
            {

                subarrayCount+=1;

            }
            //if there are any prefix sum then just add that count
            if(map.containsKey(sum-k))
            {
                //System.out.println(map.getOrDefault(sum-k,1));
                subarrayCount+=map.get(sum-k);
            }
            //add count of sum in map
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        System.out.println(map);
        return subarrayCount;
    }
}
