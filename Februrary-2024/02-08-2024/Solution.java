import java.util.Arrays;

class Solution {
    private int countMin(int ind, int[] arr, int n, int[][] dp) {
        if(ind < 0) {
            return (int)1e6;
        }
        if(n == 0) {
            return 0;
        }
        if(dp[ind][n] != -1) {
            return dp[ind][n];
        }
        int notTake = 0 + countMin(ind-1, arr, n, dp);
        int take = (int)1e6;
        if(n - arr[ind] >= 0) {
            take = 1 + countMin(ind, arr, n - arr[ind], dp);
        }
        return dp[ind][n] = Integer.min(take, notTake);
    }
    public int numSquares(int n) {
        int size = (int)Math.sqrt(n);
        int[] arr = new int[size];
        int[][] dp = new int[size][n+1];

        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<size;i++) {
            arr[i] = (i+1) * (i+1);
        }
        return countMin(size-1,arr, n, dp);
    }
}