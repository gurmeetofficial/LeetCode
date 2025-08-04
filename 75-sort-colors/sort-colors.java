class Solution {
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right]=temp;
        return;
    }
    public void sortColors(int[] nums) {
        int low=0, mid=0, high=nums.length-1;
        while (mid<=high) {
            if(nums[mid]==0) {
                swap(nums, low, mid);
                mid++;low++;
            } else if(nums[mid]==2) {
                swap(nums, high, mid);
                high--;
            } else {
                mid++;
            }
        }
    }
}