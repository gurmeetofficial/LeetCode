class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums==null || nums.length<4) {
            return res;
        }
        for(int i=0;i<len-3;i++) {
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            if((long)nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target) continue;
            for(int j=i+1;j<len-2;j++) {
                int left = j+1, right=len-1;
                long restTarget = (long)target-nums[i]-nums[j];
                while(left<right) {
                    long curSum = nums[left]+nums[right];
                    if(curSum==restTarget) {
                        List<Integer> cur = new ArrayList<>();
                        
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        while(left<right && nums[left]==cur.get(2)) {
                            left++;
                        }
                        while(left<right && nums[right]==cur.get(3)) {
                            right--;
                        }
                    } else if (curSum<restTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while(j+1<len-2 && nums[j]==nums[j+1]) {
                    j++;
                }
            }
            while(i+1<len-3 && nums[i]==nums[i+1]) {
                i++;
            }
        }
        return res;
    }
}