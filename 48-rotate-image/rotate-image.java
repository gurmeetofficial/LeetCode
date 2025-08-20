class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length-1;
        int end = len;
        int start=0;
        while(start<end) {
            int rowEnd = end;
            for(int j=start;j<rowEnd;j++) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[len-j][start];
                matrix[len-j][start] = matrix[end][len-j];
                matrix[end][len-j] = matrix[j][end];
                matrix[j][end] = temp;
            }
            start++;end--;
        }
    }
}