class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        int result = -1;
        for(int i=0;i<trust.length;i++) {
            inDegree[trust[i][1]-1]++;
            outDegree[trust[i][0]-1]++;
        }
        for(int i=0;i<n;i++) {
            if(inDegree[i] == n-1 && outDegree[i] == 0) {
                result = i+1;
                break;
            }
        }
        return result;
    }
}