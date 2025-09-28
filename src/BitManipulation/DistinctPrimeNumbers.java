package BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeNumbers {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> distinctPrimeFactors = new HashSet<>();

        for (int num : nums) {
            // Factor out all 2s
            if (num % 2 == 0) {
                distinctPrimeFactors.add(2);
                while (num % 2 == 0) {
                    num /= 2;
                }
            }

            // Factor out odd numbers
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    distinctPrimeFactors.add(i);
                    while (num % i == 0) {
                        num /= i;
                    }
                }
            }

            // If a prime number greater than 2 remains
            if (num > 2) {
                distinctPrimeFactors.add(num);
            }
        }

        return distinctPrimeFactors.size();

    }


    public static void main(String[] args) {
        DistinctPrimeNumbers dpn = new DistinctPrimeNumbers();
        int arr[] = new int[]{2,14,19,19,5,13,18,10,15,20};
        long max=1;
        for(int I:arr){
            System.out.println(max*I);
            max=max*I;
            if(max>Integer.MAX_VALUE)
                System.out.println(true );;
        }
        System.out.println(dpn.distinctPrimeFactors(arr));
    }
}
