class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length,cols = matrix[0].length;
        boolean firstColZero=false,firstRowZero=false;
        for(int i=0;i<cols;i++) {
            if(matrix[0][i]==0) {
                firstRowZero=true;
                break;
            }
        }
        for(int i=0;i<rows;i++) {
            if(matrix[i][0]==0) {
                firstColZero=true;
                break;
            }
        }
        for(int row=1;row<rows;row++) {
            for(int col=1;col<cols;col++) {
                if(matrix[row][col]==0) {
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }
        for(int i=1;i<rows;i++) {
            if(matrix[i][0]==0) {
                for(int j=0;j<cols;j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<cols;j++) {
            if(matrix[0][j]==0) {
                for(int i=0;i<rows;i++) {
                    matrix[i][j]=0;
                }
            }
        }
        if(firstColZero) {
            for(int i=0;i<rows;i++) {
                matrix[i][0]=0;
            }
        }

        if(firstRowZero) {
            for(int i=0;i<cols;i++) {
                matrix[0][i]=0;
            }
        }
    }
}