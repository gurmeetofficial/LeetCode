class Solution {
    public int majorityElement(int[] nums) {
        int count=0, res=nums[0];
        for(int num:nums) {
            if(num==res) count++;
            else {
                count--;
                if(count<0) {
                    res=num;
                    count=1;
                }
            }
        }
        return res;
    }
}