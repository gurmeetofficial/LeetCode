class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int res=nums[0],maxCount=0;
        for(int key:map.keySet()) {
            if(map.get(key)>maxCount) {
                maxCount = map.get(key);
                res = key;
            }
        }
        return res;
    }
}