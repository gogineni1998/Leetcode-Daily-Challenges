import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) { 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int i=1;i<heights.length;i++) {
            if(heights[i] - heights[i-1] > 0 && bricks >= heights[i] - heights[i-1]) {
                pq.add(-1 * (heights[i] - heights[i-1]));
                bricks = bricks - (heights[i] - heights[i-1]);
            }
            else if(heights[i] - heights[i-1] > 0 && ladders > 0) {
                ladders = ladders - 1;
                pq.add(-1 * (heights[i] - heights[i-1]));
                bricks = bricks - pq.poll() - (heights[i] - heights[i-1]);
            }
            else if(heights[i] - heights[i-1] > 0) {
                break;
            }
            res = i;
        }
        return res; 
    }
}