class Solution {

    private int calculateSum(int num) {
        int sqrtNum = (int)Math.sqrt(num);
        int sum=1+num, numOfDiv=2;
        for(int i=2;i<=sqrtNum;i++) {
            if(num%i==0) {
                sum+=i;
                numOfDiv++;
                if(num/i!=i) {
                    sum+=num/i;
                    numOfDiv++;
                }
            }
            if(numOfDiv>4) break;
        }
        if(numOfDiv==4) return sum;
        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for(int num:nums) {
            res+=calculateSum(num);
        }
        return res;
    }
}