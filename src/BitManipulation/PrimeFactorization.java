package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(12246));

        //a number can have at max one prime factor greater than sqrt(n)
        //why?
        //let's assume a number n has two prime factors greater than sqrt(n)
        //let's call them p1 and p2
        //so p1>sqrt(n) and p2>sqrt(n)
        //so p1*p2>sqrt(n)*sqrt(n)
        //so p1*p2>n
        //which is a contradiction because p1 and p2 are factors of n
        //hence a number can have at max one prime factor greater than sqrt(n)

        //How to find that number?
        //let's say we have a number n
        //we can keep dividing n by all the prime numbers less than sqrt(n)
        //if n becomes 1 then we don't have any prime factor greater than sqrt(n)
        //if n is still greater than 1 then n itself is a prime factor greater than sqrt(n)
        int n=177;
        List<Integer> answer=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            while(n%i==0){
                answer.add(i);
                n=n/i;
            }
        }
        if(n>1){
            answer.add(n);
        }
        System.out.println(answer);

    }
}
