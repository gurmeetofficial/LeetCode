class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int itr;
        for(int key:map.keySet()) {
            itr = map.get(key);
            if(itr>len/3) {
                res.add(key);
            }
        }
        return res;
    }
}