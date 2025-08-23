class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int resCount=0, curCount=0, res=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                curCount = map.getOrDefault(nums[i],0)+1;
                if(curCount>resCount) {
                    resCount = curCount;
                    res = nums[i];
                } else if(curCount==resCount) {
                    if(nums[i]<res) {
                        res = nums[i];
                    }
                }
                map.put(nums[i], curCount);
            }
        }
        return res;
    }
}