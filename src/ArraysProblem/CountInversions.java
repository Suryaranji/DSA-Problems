package ArraysProblem;

public class CountInversions {
    static long merge(int left,int mid,int right,long []arr)
    {
        long inversions=0;int j=left;
        for(int i=mid+1;i<=right;i++)
        {
            while(j<=mid&&arr[j]<=arr[i])
            {
                j++;
            }
            inversions+=mid-j+1;
        }
        long temparray[]=new long[right-left+1];
        int tempindex=0,i=left;j=mid+1;
        while(i<=mid&&j<=right)
        {
            if(arr[i]<=arr[j])
            {
                temparray[tempindex++]=arr[i++];
            }
            else
            {
                temparray[tempindex++]=arr[j++];
            }
        }
        while(i<=mid)
        {
            temparray[tempindex++]=arr[i++];
        }
        while(j<=right)
        {
            temparray[tempindex++]=arr[j++];
        }
        for(i=left;i<=right;i++)
        {
            arr[i]=temparray[i-left];
        }
        return inversions;
    }

    static long mergesort(int left,int  right,long arr[])
    {
        long count=0;
        if(left<right)
        {
            int mid=(left+right)>>1;
            count+=mergesort(left,mid,arr);
            count+=mergesort(mid+1,right,arr);
            count+=merge(left,mid,right,arr);
        }
        return count;
    }
    static long inversionCount(long arr[], int N)
    {
        return mergesort(0,N-1,arr);
    }
}
