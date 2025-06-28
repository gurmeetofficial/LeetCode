class Solution {
    private boolean checkPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
    public int primePalindrome(int n) {
        if(n>=8 &&n<12) return 11;
        for(int length=1;length<6;length++) {
            int start = (int)Math.pow(10, length-1);
            int end = (int)Math.pow(10, length);
            for(int i=start;i<end;i++) {
                String s = Integer.toString(i);
                StringBuilder sb=new StringBuilder(s);
                s=s+sb.reverse().deleteCharAt(0);
                int temp = Integer.parseInt(s);
                if(temp>=n && checkPrime(temp)) return temp;
            }
        }
        return -1;
    }
}