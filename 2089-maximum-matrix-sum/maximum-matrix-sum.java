class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long neg = 0, lowestNo=Math.abs(matrix[0][0]), zeroCount=0;
        long res = 0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j]<0) {
                    neg++;
                }
                lowestNo = Math.min(lowestNo, Math.abs(matrix[i][j]));
                if(matrix[i][j]==0) zeroCount++;
                res+=Math.abs(matrix[i][j]);
            }
        }
        if(neg%2!=0 && zeroCount==0) res-=(lowestNo*2);
        return res;
    }
}