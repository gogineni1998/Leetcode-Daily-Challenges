class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++) {
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<words[i].length();j++) {
                sb.append(words[i].charAt(j));
            }
            if(sb.reverse().toString().equals(words[i])) {
                return words[i];
            }
        }
        return "";
    }
}