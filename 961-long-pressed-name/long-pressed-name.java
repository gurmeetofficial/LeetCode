class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;
        while(i<name.length()&&j<typed.length()) {
            if(name.charAt(i)==typed.charAt(j)) {
                i++;j++;
            } else {
                if(
                    (i==0)
                    ||
                    (name.charAt(i-1)!=typed.charAt(j))
                ) {
                    return false;
                } else {
                    j++;
                }
            }
        }
        while(j<typed.length()) {
            if(typed.charAt(j)!=name.charAt(i-1)) return false;
            else j++;
        }
        if(i==name.length()) return true;
        return false;
    }
}