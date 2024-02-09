import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++) {
            hash[i] = i;
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < 1+dp[j]) {
                        hash[i] = j;
                        dp[i] = 1+dp[j];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<nums.length;i++) {
            if(max<dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        while(index != hash[index]) {
            res.add(nums[index]);
            index = hash[index];
        }
        res.add(nums[index]);
        return res;
    }
}