package Heaps.problems;

import Heaps.Heap;
import Heaps.MaxHeap;
import Heaps.MinHeap;

import javax.swing.text.html.Option;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KthLargestElement {
    static void heapify(int index, int arr[], int n) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(largest, arr, n);
        }
    }


    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for (int i = N - 1; i >= 0; i--) {
            heapify(i, arr, N);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        convertMinToMaxHeap(nums.length,nums);
        System.out.println(Arrays.toString(nums));
        return nums[k-1];

    }

    public static void main(String[] args) {
        int arr[] = { 3,2,3,1,2,4,5,5,6 };
/*        KthLargestElement obj=new KthLargestElement();
        System.out.println(obj.findKthLargest(arr,4));*/

        Heap minHeap=new MaxHeap();
        for (int num : arr) {
            minHeap.insert(num);
        }
        System.out.println(minHeap.getAllElements());
        System.out.println();

        IntStream.range(0,0).forEach(i->minHeap.delete());
        System.out.println(minHeap.getFirst());
    }
}
