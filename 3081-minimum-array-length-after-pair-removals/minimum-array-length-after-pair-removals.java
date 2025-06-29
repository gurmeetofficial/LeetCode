class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.size();
        int res = len;
        for (int i = 0; i < len; i++) {
            if (i < len / 2) {
                map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            } else {
                if (map.size() > 0) {
                    int minKey = map.firstKey();
                    int minKeyVal = map.get(minKey);
                    System.out.println(minKey);
                    if (minKey < nums.get(i) && minKeyVal > 0) {
                        res -= 2;
                        if (minKeyVal == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    } else {
                        map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                    }
                } else {
                    map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                }
            }
        }
        return res;
    }
}