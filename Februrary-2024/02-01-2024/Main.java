import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        if(nums.length % 3 != 0) {
            return new int[0][0];
        }
        int[][] result = new int[nums.length / 3][3];
        int ptr1 = 0;
        int ptr2 = 2;
        int ind = 0;
        Arrays.sort(nums);
        while(ptr2 < nums.length) {
            if(nums[ptr2] - nums[ptr1] <= k && nums[ptr2] - nums[ptr1 + 1] <= k && nums[ptr2 - 1] - nums[ptr1] <= k) {
                result[ind][0] = nums[ptr1];
                result[ind][1] = nums[ptr1 + 1];
                result[ind][2] = nums[ptr1 + 2];
                ptr1 = ptr1 + 3;
                ptr2 = ptr2 + 3;
                ind = ind + 1;
            } else {
                return new int[0][0];
            }
        }
        return result;
    }
}