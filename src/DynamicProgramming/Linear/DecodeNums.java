package DynamicProgramming.Linear;

import java.util.Arrays;

public class DecodeNums {


    /*
    *91. Decode Ways
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

     */

    public int decodes(String s, int index, int dp[]) {
        //base case when to stop
        if (index == s.length()) {
            return 1;
        }
        if (dp[index] != -1)
            return dp[index];
        int combinations = 0;
        for (int i = index; i < s.length(); i++) {
            //if first char is 0 hence we cannot make any pair with other numbers
            boolean zero = s.charAt(index) == '0';
            if (zero) {
                return 0;
            }
            if (i - index >= 2) {
                break;
            }
            int number = Integer.parseInt(s.substring(index, i + 1));
            if ((number > 0 && number <= 26)) {
                combinations += decodes(s, i + 1, dp);

            }

        }
        return dp[index] = combinations;
    }

    public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        // Arrays.fill(dp, -1);
        //   return decodes(s,0,dp);

        //tabulation
        int n = s.length();

        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int combinations = 0;
            for (int j = i; j < s.length(); j++) {
                boolean zero = s.charAt(i) == '0';
                if (zero) {
                    break;
                }
                //if first char is 0 hence we cannot make any pair with other numbers
                if (j - i > 2) {
                    break;
                }
                int number = Integer.parseInt(s.substring(i, j + 1));
                if ((number > 0 && number <= 26)) {
                    combinations += dp[j + 1];

                }
            }
            dp[i] = combinations;

        }

        return dp[0];

    }

    public static void main(String[] args) {
        DecodeNums dn = new DecodeNums();
        System.out.println(dn.numDecodings("226"));
        System.out.println(dn.numDecodings("12"));
        System.out.println(dn.numDecodings("06"));
        System.out.println(dn.numDecodings("2318232103"));
    }
}
