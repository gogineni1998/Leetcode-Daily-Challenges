import java.util.Arrays;

class Solution {
    private int getCherries(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if(j1 == -1 || j1 == grid[0].length || j2 == -1 || j2 == grid[0].length) {
            return (int) (Math.pow(-10, 9));
        }
        if(i == grid.length) {
            return 0;
        }
        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int d1 = -1;d1 <= 1;d1++) {
            for(int d2 = -1;d2<=1;d2++) {
                ans = 0;
                if(j1 == j2) {
                    ans = grid[i][j1] + getCherries(i+1, j1+d1, j2+d2, grid, dp);
                } else {
                    ans = (grid[i][j1] + grid[i][j2]) + getCherries(i+1, j1+d1, j2+d2, grid, dp);
                }
                max = Integer.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getCherries(0, 0, grid[0].length-1, grid, dp);
    }
}