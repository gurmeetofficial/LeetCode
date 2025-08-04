class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int len = grid[0].length;
        int[] hash = new int[len*len];
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                hash[grid[i][j]-1]++;
            }
        }
        for(int i=0;i<len*len;i++) {
            // System.out.println();
            if(hash[i]==0) res[1]=i+1;
            if(hash[i]==2) res[0]=i+1;
        }
        return res;
    }
}