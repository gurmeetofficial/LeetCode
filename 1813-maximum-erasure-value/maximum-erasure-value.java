class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0, right=0;
        int len = nums.length;
        int curSum=0, maxSum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int curKey, prevKey;
        while(right<len) {
            curKey = nums[right];
            if(map.containsKey(curKey) && map.get(curKey)>0) {
                while(left<right) {
                    prevKey = nums[left];
                    left++;
                    if(prevKey==curKey) {
                        break;
                    } else {
                        curSum -= prevKey;
                        map.put(prevKey, map.get(prevKey)-1);
                    }
                }
            } else {
                map.put(curKey, map.getOrDefault(curKey, 0)+1);
                curSum+=curKey;
                maxSum = Math.max(curSum, maxSum);
            }
            right++;
        }
        maxSum = Math.max(curSum, maxSum);
        return maxSum;
    }
}