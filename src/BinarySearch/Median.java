package BinarySearch;

public class Median {
    public static double median(int[] a, int[] b) {
/*
Link:https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
int arr1[]={2,4,6};
        int arr2[]={1,3};
        System.out.println(Median.median(arr1,arr2));
 */

        int symmetrylength=(a.length+b.length+1)/2;
        int minimumarraylength=Math.min(a.length,b.length);
        int totallength=a.length+b.length;
        if(a.length>b.length)return median(b,a);
        double answer=0;
        int low=0,high=minimumarraylength;
        while(low<=high)
        {
            int mid1=low+(high-low)/2;
            int mid2=symmetrylength-mid1;

            int r1=mid1<a.length?a[mid1]:Integer.MAX_VALUE;
            int l1=mid1>0?a[mid1-1]:Integer.MIN_VALUE;
            int r2=mid2<b.length?b[mid2]:Integer.MAX_VALUE;
            int  l2=mid2>0?b[mid2-1]:Integer.MIN_VALUE;
            if(l1<=r2&&l2<=r1)
            {
                if(totallength%2==0)
                {
                    answer=(double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else
                {
                    answer=Math.max(l1,l2);
                }

            }
            if(l1>r2)
            {
                high=mid1-1;
            }
            else
            {
                low=mid1+1;

            }

        }
        return answer;

    }
}
