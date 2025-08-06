class Solution {
    public void setZeroes(int[][] matrix) {
    boolean firstRowZero = false, firstColZero = false;
    // Check if first row needs to be zeroed
    for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0) { firstRowZero = true; break; }
    }
    // Check if first column needs to be zeroed
    for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][0] == 0) { firstColZero = true; break; }
    }
    // Use first row & column as markers
    for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    // Zero columns based on first row markers
    for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0) {
            for (int i = 1; i < matrix.length; i++)
                matrix[i][j] = 0;
        }
    }
    // Zero rows based on first column markers
    for (int i = 1; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        }
    }
    // Zero first row and first column if needed
    if (firstRowZero) {
        for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
    }
    if (firstColZero) {
        for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }
}

}