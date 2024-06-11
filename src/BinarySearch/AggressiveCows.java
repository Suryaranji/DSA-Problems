package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static int solve(int n, int k, int[] arr) {
         Arrays.sort(arr);
        int low=0,high=arr[n-1];
        while(low<=high)
        {
            int mid=(low+high)>>1;
            int count=0,previous=0;
            //check if the predicted distance is possible to store cows
            for(int i=0;i<n;i++)
            {
                if(i==0||arr[i]-arr[previous]>=mid)
                {
                    count++;
                    previous=i;
                }
            }
            //if possible increase distance
            if(count<k)
            {
                high=mid-1;
            }
            //if not then reduce distance
            else
            {
                low=mid+1;
            }
        }
        return high;

    }
}
