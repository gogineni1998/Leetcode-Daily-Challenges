import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> hash_s = new HashMap<>();
        Map<Character, Integer> hash_t = new HashMap<>();

        for(int i=0;i<t.length();i++) {
            if(hash_t.containsKey(t.charAt(i))) {
                hash_t.put(t.charAt(i), hash_t.get(t.charAt(i)) + 1);
            }
            else {
                hash_t.put(t.charAt(i), 1);
            }
        }

        int count_s = 0;
        int count_t = hash_t.size();
        int l = 0;
        int r = 0;
        int result = Integer.MAX_VALUE;
        int i = -1;
        int j = -1;
        while(r < s.length()) {
            if(hash_t.containsKey(s.charAt(r)) && hash_s.containsKey(s.charAt(r))) {
                hash_s.put(s.charAt(r), hash_s.get(s.charAt(r)) + 1);
                int a = hash_t.get(s.charAt(r));
                if(hash_s.get(s.charAt(r)) == a) {
                    count_s++;
                }
            }
            else if(hash_t.containsKey(s.charAt(r))) {
                hash_s.put(s.charAt(r), 1);
                int a = hash_t.get(s.charAt(r));
                if(hash_s.get(s.charAt(r)) == a) {
                    count_s++;
                }
            }
            
            while(count_s == count_t) {
                if(r - l + 1 < result) {
                    i = l;
                    j = r;
                    result = r - l + 1; 
                }
                if(hash_s.containsKey(s.charAt(l))) {
                    hash_s.put(s.charAt(l), hash_s.get(s.charAt(l)) - 1);
                    if(hash_s.get(s.charAt(l)) < hash_t.get(s.charAt(l))) {
                        count_s = count_s - 1;
                    }
                }
                l = l + 1;
            }
            r = r + 1;
        }
        return i == -1 && j == -1 ? "" : s.substring(i,j+1);
    }
}