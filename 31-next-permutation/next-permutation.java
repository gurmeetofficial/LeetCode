class Solution {
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int smallIndex = -1;
        int largeIndex = len - 1;
        for (int i = len - 2; i >= 0; i -= 1) {
            if (nums[i] < nums[i + 1]) {
                smallIndex = i;
                break;
            }
        }
        if (smallIndex == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > smallIndex; i -= 1) {
            if (nums[i] > nums[smallIndex]) {
                largeIndex = i;
                break;
            }
        }
        swap(nums, largeIndex, smallIndex);
        reverse(nums, smallIndex + 1, len - 1);
    }
}