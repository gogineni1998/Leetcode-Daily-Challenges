import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_Clean {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            queue.add(i);
        }
        int value = 1;
        while(value < high && queue.size() > 0) {
            value = queue.poll();
            if(value >= low && value <= high) {
                result.add(value);
            }
            if(((value % 10) + 1) < 10) {
                int temp = value * 10 + ((value % 10) + 1);
                queue.add(temp);
            }
        }
        return result;
    }
}