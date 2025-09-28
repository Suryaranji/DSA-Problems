package DynamicProgramming;

public class PatternMatching {

        //base case:
        //if both of them exhausted return truef
        // if matcher string exhaust look for pattern only have stars otherwise return false.
        //if pattern exhaust return false

        public boolean match(int indS,int indP,String s,String p,int dp[][]){
            if(indS==s.length()&& indP==p.length()){
                return true;
            }
            if(indP==p.length())return false;
            if(dp[indS][indP]!=0)return dp[indS][indP] == 1;
            boolean firstMatch= (indS < s.length() &&
                    (s.charAt(indS) == p.charAt(indP) || p.charAt(indP) == '.'));
            boolean answer;
            if (indP + 1 < p.length() && p.charAt(indP + 1) == '*') {
                // two options:
                // 1. skip this "char*" (move pattern by 2)
                // 2. if first matches, consume one char from s and stay in same pattern
                //eg: s=aa p=a*
                // 1. skip a* -> s=aa p= ""
                // 2. first matches -> s=a p=a*
                //eg: s=aa p=b*
                // 1. skip b* -> s=aa p=""
                // 2. first does not match -> s=aa p=b*
                //eg: s=ab p=b*
                // 1. skip b* -> s=ab p=""
                // 2. first does not match -> s=ab p=b*
                answer = match(indS, indP + 2, s, p, dp) ||
                        (firstMatch && match(indS + 1, indP, s, p, dp));
            } else {
                // normal case: move both forward if matches
                answer = firstMatch && match(indS + 1, indP + 1, s, p, dp);
            }
            dp[indS][indP]=answer?1:2;
            return answer;
            //mississippi  mis*is*p*. mississi
            // mis mis
            // *   s
            // is is
            // * si
            // p pp
            // * p
            // . i
        }

        public boolean isMatch(String s, String p) {
            int dp[][]=new int[s.length()+1][p.length()+1];
            return match(0,0,s,p,dp);

        }

    public static void main(String[] args) {
    //    System.out.println(new PatternMatching().isMatch("a","ab*a"));
        System.out.println(new PatternMatching().isMatch("aa","a*"));
    }

}
