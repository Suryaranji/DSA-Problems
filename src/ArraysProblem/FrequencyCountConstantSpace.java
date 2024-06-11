package ArraysProblem;

public class FrequencyCountConstantSpace {
    /*
 * Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Approach:O(1 space)

* used by calculating negatoive index
* first traverse element one by one.
* consider  that at as index by subtracting -1 (1 based indexing the element 0 has to be in 1 place)
* if that index contains positive element that it is the first time we encounter that element
* swap it with current index
* update that inex as -1(first occurence)
* else
* decrement that index and make current index as 0
* finally multiply all elements with -1.

 */
    public static void frequencyCount(int arr[], int N, int P)
    {
        int i=0;
        while(i<N)
        {
            if(arr[i]<=0)
            {
                i++;
                continue;
            }
            int element=arr[i]-1;
            if(arr[element]>0)
            {
                arr[i]=arr[element];
                arr[element]=-1;
            }
            else
            {
                arr[element]--;
                arr[i]=0;
                i++;
            }
        }
        for(i=0;i<N;i++)arr[i]*=-1;
    }
}
