class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1,index=1;
        for(int i=1;i<nums.length;i++) {
            if (nums[i]==nums[i-1]) count++;
            else count=1;
            if (count<3) nums[index++]=nums[i];
        }
        return index;
    }
}