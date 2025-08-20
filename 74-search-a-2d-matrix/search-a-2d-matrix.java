class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=-1, len = matrix.length;
        int rowLen = matrix[0].length;
        if(matrix[0][0]>target || matrix[len-1][rowLen-1]<target) return false;
        for(int i=0;i<len;i++) {
            if(matrix[i][0]==target) return true;
            else if(matrix[i][0]<=target && matrix[i][rowLen-1]>=target) {
                row = i;
                break;
            }
        }
        if(row==-1) return false;
        int start=0,end=rowLen-1;
        int mid;
        while(start<=end) {
            mid = (end+start)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target) end = mid-1;
            else start=mid+1;
        }
        return false;
    }
}