import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new TreeMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<strs.length;i++) {
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String t = new String(temp);
            if(map.containsKey(t)) {
                map.get(t).add(strs[i]);
            }
            else {
                map.put(t, new ArrayList<>());
                map.get(t).add(strs[i]);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}