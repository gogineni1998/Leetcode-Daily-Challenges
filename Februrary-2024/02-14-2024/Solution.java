import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negetive = new ArrayList<>();
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                positive.add(nums[i]);
            }
            else {
                negetive.add(nums[i]);
            }
        }
        int i = 0;
        int j = 0;
        int ind = 0;
        while(i < positive.size() && j < negetive.size()) {
            result[ind++] = positive.get(i++);
            result[ind++] = negetive.get(j++);
        }
        while(i < positive.size()) {
            result[ind++] = positive.get(i++);
        }
        while(j < negetive.size()) {
            result[ind++] = negetive.get(j++);
        }
        return result;
    }
}