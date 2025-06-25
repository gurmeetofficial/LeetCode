class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k==0) {
            Arrays.fill(code,0);
            return code;
        }
        int absK = Math.abs(k);
        int sum=0, len=code.length;
        for(int i=0;i<absK;i++) sum+=code[i];
        int[] res = new int[len];
        int itr=absK;
        for(int i=0;i<len;i++) {
            if(itr>=len) itr=0;
            System.out.println(i+" - "+itr+" - "+sum);
            System.out.println(code[i]+" - "+code[itr]);
            if(k>0) {
                sum = sum - code[i]+code[itr];
                res[i]=sum;
            } else {
                res[itr] = sum;
                sum = sum - code[i]+code[itr];
            }
            itr++;
        }
        return res;
    }
}