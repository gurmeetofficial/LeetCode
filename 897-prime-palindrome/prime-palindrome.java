class Solution {
    public Boolean checkPrime(int n) {
        if(n==1) return false;
        for(int i=2;i<=n/2;i++) {
            if(n%i==0) return false;
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
                // System.out.println(s);
                if(temp>=n && checkPrime(temp)) return temp;
            }
        }
        return -1;
    }
}