package BinarySearch;

public class KthSmallestInMultplicationTable {
    public int findKthNumber(int m, int n, int k) {

        if(m>n)return findKthNumber(n,m,k);
        int low=1,high=m*n,answer=0;
        while(low<=high)
        {
            //to  check if the element be my kth smallest element
            //i have to check whether i can get k-1 smaller elements before that
            int mid=(low+high)>>1;
            int lesserElements=0;
            //calculate number of elements smaller than mid
            for(int i=1;i<=m;i++)
            {
                //this checks how many elemnts in that row lesser than mid by taking minimum between
                //either it has to be length or number of elements that lesser by dividing the number by row number(if 2nd row and has 3 elements i want 6 than 6/2=3 )
                lesserElements+=Math.min(n,mid/i);
            }
            //if greater than or equal to k than my answer may be that or before that because i can have same number before as well
            if(lesserElements>=k)
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
