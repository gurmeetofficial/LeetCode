class Solution {

    public void sort(int[] arr, int start, int mid, int end) {
        int leftArrLength = mid - start + 1;
        int rightArrLength = end - mid;
        int[] left = new int[leftArrLength];
        int[] right = new int[rightArrLength];
        for (int i = 0; i < leftArrLength; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < rightArrLength; i++) {
            right[i] = arr[mid + i + 1];
        }
        int leftItr = 0, rightItr = 0, mainItr = start;
        while (leftItr < leftArrLength && rightItr < rightArrLength) {
            if (left[leftItr] <= right[rightItr]) {
                arr[mainItr] = left[leftItr];
                leftItr++;
            } else {
                arr[mainItr] = right[rightItr];
                rightItr++;
            }
            mainItr++;;
        }
        while (leftItr < leftArrLength) {
            arr[mainItr] = left[leftItr];
            mainItr++;
            leftItr++;
        }
        while (rightItr < rightArrLength) {
            arr[mainItr] = right[rightItr];
            mainItr++;
            rightItr++;
        }
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            sort(nums, start, mid, end);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}