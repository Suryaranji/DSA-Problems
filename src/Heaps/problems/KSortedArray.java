package Heaps.problems;

import java.util.Arrays;

public class KSortedArray {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here

        int[] temp = Arrays.copyOf(arr,n);
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        for(int i=0;i<n;i++){
            int ele=arr[i];
            if ((k + i < n && ele > temp[k + i]) || (i - k >= 0 && ele < temp[i - k])) {
                System.out.println(ele);
                return "No";
            }
        }
        //  System.out.println(Arrays.toString(temp));
        return "Yes";
        //3 2 1 5 6 4
        //1 2 3 4 5 6
    }

    public static void main(String[] args) {
      //  int arr[] = {18, 44, 12, 27, 4, 19, 42, 8, 34, 15, 38, 5, 16, 47, 1, 6, 32, 40, 10, 33, 22};
        int arr[] = {3, 2, 1, 5, 6, 4};
        System.out.println(isKSortedArray(arr, arr.length, 2));
    }
}
