class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        Arrays.sort(nums);
        int len = nums.length;
        int maxLen = 1, curLen=1;
        for(int i=1;i<len;i++) {
            if(nums[i]-nums[i-1]==1) {
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else if (nums[i]-nums[i-1]==0) {
                continue;
            } else curLen=1;
        }
        return maxLen;
    }
}