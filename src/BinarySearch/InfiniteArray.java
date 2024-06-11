package BinarySearch;

public class InfiniteArray {
    static int get(long i) {
        return 0;
    }

    public static long firstOne()
    {
        long low=0,high=1;
     /*
     find the high by multiplying high by 2 whenever it gets 0
     */
        while(get(high)<1)
        {
            low=high;
            high*=2;
        }
        while(low<=high)
        {
            long mid=(low+high)>>1;
            if(get(mid)==1)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}
