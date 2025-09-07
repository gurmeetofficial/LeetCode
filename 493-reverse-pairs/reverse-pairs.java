class Solution {

    public void sort(int[] nums, int start, int mid, int end) {
        int firArrLen = mid-start+1;
        int secArrLen = end-mid;
        int[] firArr = new int[firArrLen];
        int[] secArr = new int[secArrLen];
        for(int i=0;i<firArrLen;i++) {
            firArr[i] = nums[start+i];
        }
        for(int i=0;i<secArrLen;i++) {
            secArr[i] = nums[mid+i+1];
        }
        int firItr=0,secItr=0,mainItr=start;
        while(firItr<firArrLen && secItr<secArrLen) {
            if(firArr[firItr]<=secArr[secItr]) {
                nums[mainItr] = firArr[firItr];
                firItr++;
            } else {
                nums[mainItr] = secArr[secItr];
                secItr++;
            }
            mainItr++;
        }
        while(firItr<firArrLen) {
            nums[mainItr] = firArr[firItr];
                firItr++;
                mainItr++;
        }
        
        while(secItr<secArrLen) {
            nums[mainItr] = secArr[secItr];
                secItr++;
                mainItr++;
        }
    }

    public int mergeSort(int[] nums, int start, int end) {
        if(start<end) {
            int mid = start + (end - start) / 2;
            int count = mergeSort(nums, start, mid)+mergeSort(nums, mid+1, end);
            // check here for count
            int j=mid+1;
            for(int i=start;i<=mid;i++) {
                while(j<=end && nums[i]>(long)nums[j]*2) {
                    j++;
                }
                count += j-(mid+1);
            }
            //sort the subPart
            sort(nums, start, mid, end);
            return count;
        } else return 0;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}