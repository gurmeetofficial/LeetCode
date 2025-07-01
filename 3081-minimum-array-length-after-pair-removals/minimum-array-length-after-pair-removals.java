class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n=nums.size(),i=0,j=n/2;
        while(i<n/2&&j<n) {
            if(nums.get(i)<nums.get(j)) {
                i++;j++;
            } else {
                j++;
            }
        }
        return n-2*i;
    }
}