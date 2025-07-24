class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    bitCount++;
                }
            }

            if (bitCount > n / 2) {
                majority |= (1 << i);
            }
        }

        return majority;
    }
}
