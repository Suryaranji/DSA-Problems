package Sorting;

public class MergeSort {

/*
*Sorting large datasets:
*             Merge sort is particularly well-suited for sorting large datasets due to its guaranteed worst-case time complexity of O(n log n).
* External sorting:
*              Merge sort is commonly used in external sorting, where the data to be sorted is too large to fit into memory.
* Custom sorting:
*              Merge sort can be adapted to handle different input distributions, such as partially sorted, nearly sorted, or completely unsorted data.
*
*
* Time Complexity:-O(nlog(n))
* Space Complexity:-O(n)
 */


    public void mergesort(int arr[],int start,int end)
    {
        if(start<end)
        {
            int mid=(start+end)>>1;
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int temparray[]=new int[end-start+1];
        int count=0;
        int tempstart=start;
        int tempmid=mid;
        mid=mid+1;
        while(start<=tempmid&&mid<=end)
        {
            if(arr[start]<arr[mid])
            {
                temparray[count++]=arr[start++];
            }
            else
            {
                temparray[count++]=arr[mid++];
            }
        }
        while(start<=tempmid)
        {
            temparray[count++]=arr[start++];

        }
        while(mid<=end)
        {
            temparray[count++]=arr[mid++];
        }
        for(int i=tempstart;i<tempstart+temparray.length;i++)
        {
            arr[i]=temparray[i-tempstart];
        }
    }
}
