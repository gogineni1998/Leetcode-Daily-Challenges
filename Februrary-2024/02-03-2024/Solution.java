import java.util.Arrays;

class Solution {
    private int getArrayPartition(int ind, int[] arr, int k, int[] dp) {
        if(ind == arr.length) {
            return 0;
        }
        if(dp[ind] != -1) {
            return dp[ind];
        }
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i=ind; i<ind+k && i < arr.length; i++) {
            max = Integer.max(max, arr[i]);
            ans = Integer.max(ans,  max * (i - ind + 1) + getArrayPartition(i+1, arr, k, dp));
        }
        return dp[ind] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return getArrayPartition(0, arr, k, dp);
    }
}