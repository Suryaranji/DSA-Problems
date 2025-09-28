package BitManipulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountPrimes {
    public int countPrimes(int n) {

        //         Given an integer n, return the number of prime numbers that are strictly less than n.



        // Example 1:

        // Input: n = 10
        // Output: 4
        // Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
        // Example 2:

        // Input: n = 0
        // Output: 0
        // Example 3:

        // Input: n = 1
        // Output: 0

        //prime number is a number divisible by 1 and itself
        //to find prime numbers that are strictly less than n
        //n=10
        //start [2-10]
        //2-> multiplicants of 2 which are less than n are not prime numbers
        //2 [4,6,8]
        //3 [6,9]
        //5 []
        //6 [multiplicants] greater so no need to proceed further(is it true)

        boolean primes[]=new boolean[n];
        int primecount=0;
        for(int i=2;i<n;i++){
            if(!primes[i]){
                primecount++;
                for(int j=i+i;j<n;j+=i){
                    primes[j]=true;

                }
            }
        }
        return primecount;
        //dry run : n=10
        // boolean [0 1 2 3 4 5 6 7 8 9 10]
        //2 ->      f f f f t f t f t f
        //3 ->.     f f f f t f t f t t
        //4->
        //5
        //6
        //7
        //8
        //9
        //10
    }

    public static void main(String[] args) {
        CountPrimes cp=new CountPrimes();
        System.out.println(cp.countPrimes(10));
        System.out.println(cp.countPrimes(0));
        System.out.println(cp.countPrimes(1));
        System.out.println(cp.countPrimes(20));
    }
}
