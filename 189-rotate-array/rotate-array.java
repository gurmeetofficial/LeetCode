class Solution {
    private void rev (int[] nums, int start, int end) {
        int temp;
        while(start<=end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int len=nums.length,temp;
        k=k%len;
        rev(nums, 0, len-1);
        rev(nums, 0, k-1);
        rev(nums, k, len-1);
        return;
    }
}