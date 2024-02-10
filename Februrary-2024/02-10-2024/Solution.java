class Solution {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int i = 0;
        int j = 0;
        while(i<s.length() && j<s.length()) {
            dp[i][j] = 1;
            i++;
            j++;
        }
        i = 0;
        j = 1;
        while(i<s.length() && j<s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
            }
            i++;
            j++;
        }
        int n = 2;
        while(n<s.length()) {
            i = 0;
            int k = n;
            while(i<s.length() && k<s.length()) {
                if(s.charAt(i) == s.charAt(k) && dp[i+1][k-1] == 1) {
                    dp[i][k] = 1;
                }
                i++;
               k++;
            }
            n++;
        }
        int count = 0;
        for(i=0;i<s.length();i++) {
            for(j=0;j<s.length();j++) {
                if(dp[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}