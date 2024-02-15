import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
        }

        for(int i=nums.length-1;i>=2;i--) {
            if(nums[i] < sum - nums[i]) {
                return sum;
            }
            sum = sum - nums[i];
        }
        return -1;
    }
}