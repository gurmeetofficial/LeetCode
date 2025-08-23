class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int countA=0,countB=0, len=nums.length;
        Integer candidateA=null,candidateB=null;
        for(int i=0;i<len;i++) {
            if (candidateA !=null && nums[i]==candidateA) countA++;
            else if (candidateB !=null && nums[i]==candidateB) countB++;
            else if (countA==0) {
                candidateA=nums[i];
                countA++;
            }
            else if (countB==0) {
                candidateB=nums[i];
                countB++;
            } 
            else {
                countA--;countB--;
            }
        }
        countA=0;countB=0;
        for(int i=0;i<len;i++) {
            if(nums[i]==candidateA) countA++;
            else if(candidateB!=null && nums[i]==candidateB) countB++;
        }
        List<Integer>res = new ArrayList<>();
        if (countA>len/3) res.add(candidateA);
        if (countB>len/3 && candidateA != candidateB) res.add(candidateB);
        return res;
    }
}