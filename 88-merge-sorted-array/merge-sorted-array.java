class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int itr=m+n;
        m-=1;n-=1;
        while(m>-1 &&n>-1) {
            if(nums1[m]>nums2[n]) {
                nums1[--itr] = nums1[m--];
            } else {
                nums1[--itr] = nums2[n--];
            }
        }
        while(n>-1) {
            nums1[--itr]=nums2[n--];
        }
        return;
    }
}