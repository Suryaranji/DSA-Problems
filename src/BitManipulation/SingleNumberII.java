package BitManipulation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {

        //The concept behind this approach is to use two variables (a and b) to keep track of the bits that have appeared once and twice respectively.
        // When a bit appears for the first time, it is recorded in 'a'. When
        // it appears for the second time, it is moved to 'b'. When it appears for the third time, it is removed from both 'a' and 'b'.
        // At the end of the iteration, 'a' will contain the bits of the number
        // that appeared only once.
        int a=0;
        int b=0;
        for(int i:nums){
            a=(a^i)&~b;
            b=(b^i)&~a;
        }
        return a;

    }
    public static void main(String[] args) {
        SingleNumberII sn2=new SingleNumberII();
        //generate some more testing examples

        int arr[]=new int[]{2,2,3,2};
        System.out.println(sn2.singleNumber(arr));




    }
}
