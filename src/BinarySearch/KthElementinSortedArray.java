package BinarySearch;

import java.util.ArrayList;

public class KthElementinSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

       /* if(m>n)
        {
            return kthElement(  arr2,arr1,  m,n,k);
        }*/


        long answer = 0;
        int low = Math.max(0, k - m);
        /*
        intitialize low to either 0 or k-m
        K-m beacause if the left part of first array is nothing and second array containing lesser elements
        than K then we cant find kth element hence we take remaining elements from 1st array

        k=5 and second array containing 4 elements
        and pointer moves to 0 then we have to take remaining one element from 1st array(
        since max(0,k-4)--> (0,(5-4)=1)
        */
        int high = Math.min(n, k);
        /*
        low to either n or k minimum because if k=1 and we have low=0 and high =5 then it gives mid =2 but
        we need only one element to left half so by making minimum then it only gives one element
        */
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (k - cut1);
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                answer = Math.max(left1, left2);
                break;
            }
            if (left1 > right2) {
                high = cut1 - 1;

            } else {
                low = cut1 + 1;
            }
        }
        return answer;
    }
    }
