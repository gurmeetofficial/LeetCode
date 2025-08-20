class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length-1;
        int matched=0;
        int requiredMatches = mat.length*mat.length;
        for(int i=0;i<=len;i++) {
            for(int j=0;j<=len;j++) {
                if(mat[i][j]!=target[j][len-i]) break;
                else matched++;
            }
        }
        if(matched==requiredMatches) return true;
        matched=0;
        for(int i=0;i<=len;i++) {
            for(int j=0;j<=len;j++) {
                if(mat[i][j]!=target[len-i][len-j]) break;
                else matched++;
            }
        }
        if(matched==requiredMatches) return true;
        matched=0;
        for(int i=0;i<=len;i++) {
            for(int j=0;j<=len;j++) {
                if(mat[i][j]!=target[len-j][i]) break;
                else matched++;
            }
        }
        if(matched==requiredMatches) return true;
        matched=0;
        for(int i=0;i<=len;i++) {
            for(int j=0;j<=len;j++) {
                if(mat[i][j]!=target[i][j]) break;
                else matched++;
            }
        }
        if(matched==requiredMatches) return true;
        return false;
    }
}