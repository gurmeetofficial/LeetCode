class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0,len=nums.length;
        while(fast<len) {
            if(nums[fast]!=val) {
                nums[slow++]=nums[fast];
            }
            fast++;
        }
        return slow;
    }
}