class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int i=0,n=nums.size(),j=n/2;
        int res=0;
        while(i<n/2 && j<n) {
            if(nums.get(i)<nums.get(j)) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
        }
        return n-(res*2);
    }
}