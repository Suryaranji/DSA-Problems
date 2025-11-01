package Heaps.problems;

public class MinHeapToMax {
    static void convert(int index,int arr[],int n){
        if(index>=n){
            return;
        }
        int left=2*index+1;
        int right=2*index+2;
        convert(left,arr,n);
        convert(right,arr,n);
        int largest=index;
        if(left<n||right<n){
            if(left<n&&arr[left]>arr[largest]){
                largest=left;
            }
            if(right<n&&arr[right]>arr[largest]){
                largest=right;
            }
            if(largest!=index){
                int temp=arr[largest];
                arr[largest]=arr[index];
                arr[index]=temp;
                heapify(largest,arr,n);
            }
        }
    }
    static void heapify(int index,int []arr,int n){
        if(index>=n){
            return;
        }
        int left=2*index+1;
        int right=2*index+2;
        int largest=index;
        if(left<n||right<n){
            if(left<n&&arr[left]>arr[largest]){
                largest=left;
            }
            if(right<n&&arr[right]>arr[largest]){
                largest=right;
            }
            if(largest!=index){
                int temp=arr[largest];
                arr[largest]=arr[index];
                arr[index]=temp;
                heapify(largest,arr,n);
            }
        }


    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        convert(0,arr,N);

    }

    public static void main(String[] args) {
        int arr[]={1, 3,13, 6, 3, 14, 13};
        convertMinToMaxHeap(arr.length,arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
