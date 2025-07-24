class Solution {
    HashMap<String, Boolean> dp = new HashMap();
    public boolean canSplitArrayRec(List<Integer> nums, int m, int left, int right, int sum) {
        String mapKey = left + "," + right;
        if(dp.containsKey(mapKey)) return dp.get(mapKey);
        if(right-left<1) return true;
        if(sum<m) return false;
        Boolean res = (
            canSplitArrayRec(nums, m, left+1, right, sum-nums.get(left))
            ||
            canSplitArrayRec(nums, m, left, right-1, sum-nums.get(right))
        );
        dp.put(mapKey, res);
        return res;
    }

    public boolean canSplitArray(List<Integer> nums, int m) {
        int sum=0, len=nums.size();
        if(len<3) return true;
        for(int i=0;i<len;i++) {
            sum+=nums.get(i);
        }
        return canSplitArrayRec(nums, m, 0, len-1, sum);
    }
}