import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new TreeMap<>();
        for(int i=0;i<arr.length;i++) {
            if(map1.containsKey(arr[i])) {
                map1.put(arr[i], map1.get(arr[i]) + 1);
            }
            else {
                map1.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(!map2.containsKey(entry.getValue())) {
                map2.put(entry.getValue(), new ArrayList<>());
            }
            List<Integer> temp = map2.get(entry.getValue());
            temp.add(entry.getKey());
            map2.put(entry.getValue(), temp);
        }
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
            List<Integer> temp = entry.getValue();
            for(int i=0;i<temp.size();i++) {
                k = k - entry.getKey();
                if(k < 0) {
                res = res + 1;
            }
            }
        }
        return res;
    }
}