package BinarySearch;

public class peakElement {
    public int peakElement(int[] arr,int n)
    {
        int peak=-1;
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            //if the middle element is first then there may be a possibility of me having greater element on right
            //or if greater than previous element also then ther may be possibility
            if(mid-1<0||arr[mid]>=arr[mid-1])
            {
                // System.out.println(high);
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return high;

    }
}
