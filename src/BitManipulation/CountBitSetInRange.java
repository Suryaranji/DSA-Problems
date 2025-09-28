package BitManipulation;

public class CountBitSetInRange {
        public int[] countBits(int n) {

            //qn:
            // Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



            //brute force way is to
            //iterate for each number convert them to the binary and keep on doing  & with 1 and move them to right and increment the count .
            //time complexity O(n*k) k-> approximate to the length of each number which is converted in to binary form
            //space complexity O(n)
            //10^5->100000 for 100000* len of each number

            //0 01 10 11 100 101 110 111 1000 1001 1010 1011 1100
            //0 1.  1. 2. 1.  2.  2.  3.  1.  2.    2.   3.    2
            int ans[]=new int[n+1];
            int i=1;
            while(i<=n){
                ans[i]=ans[i>>1]+(i&1);
                i++;
            }
            //12
            //8     9    10   11   12
            //1000 1001 1010 1011 1100
            //1.    2.   2.   3.   2.

            //ans[i]=ans[i>>1]+(i&1).
            // 🟢 1. The Goal

            // We want: number of 1s in binary representation of i.

            // Naive way: For each i, loop through all 32 bits → O(n·32).
            // But we want faster, by reusing previous results.

            // 🟢 2. The Key Observation

            // Take any integer i. Its binary representation looks like:

            //    [ all bits except last ]  [ last bit ]


            // Example: 13 = 1101₂
            // → [110] [1]

            // 👉 The number of ones in i is just:

            // Ones in the first part (i >> 1), plus

            // Whether the last bit is 1 (i & 1).

            // That’s exactly the formula.

            // 🟢 3. Why reuse works?

            // Notice:

            // i >> 1 is smaller than i.

            // We already computed ans[i >> 1] when filling array from 0 to n.

            // So we can build up answers without recomputing from scratch.

            // 🟢 4. Thinking Way (How I’d discover it)

            // Write down small numbers in binary and count 1s.

            // 0 → 0000 → 0
            // 1 → 0001 → 1
            // 2 → 0010 → 1
            // 3 → 0011 → 2
            // 4 → 0100 → 1
            // 5 → 0101 → 2


            // Ask: “How does ans[i] relate to smaller numbers?”

            // 3 (0011) has 2 ones.
            // Remove last bit → 1 (0001) has 1 one.
            // Add last bit → 1 more → total 2.

            // Pattern appears: ans[i] = ans[i >> 1] + (i & 1).

            // So the formula is discovered by spotting the recursive relationship.


return ans ;
        }
    public static void main(String[] args) {
        CountBitSetInRange cbs=new CountBitSetInRange();
        int n=90;
        int[] ans =cbs.countBits(n);
        for(int i:ans){
            System.out.print(i+" ");
        }

    }

}
