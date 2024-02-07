import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        int[] hash = new int[128];
        Map<Integer, List<Character>> map = new TreeMap<>();
        for(int i=0;i<s.length();i++) {
            hash[(int)s.charAt(i)]++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<hash.length;i++) {
            if(hash[i] == 0) {
                continue;
            }
            if(!map.containsKey(hash[i])) {
                map.put(hash[i], new ArrayList<>());
            }
            map.get(hash[i]).add((char) (i));
        }
        for(Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            for(int i=0;i<entry.getValue().size();i++) {
                for(int j=0;j<entry.getKey();j++) {
                    sb.append(entry.getValue().get(i));
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}