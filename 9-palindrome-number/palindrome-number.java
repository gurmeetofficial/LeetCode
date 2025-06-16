class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
        int temp=0;
        if(x<0){
            return false;
        } else {
            temp=0;
            while(x>0){
                temp=temp*10+x%10;
                x=x/10;
            }
        }
        if(y==temp){
            return true;
        }
        return false;
    }
}