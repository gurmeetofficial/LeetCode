import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int maxSum = 0;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int currentNum = nums[right];
            
            // Add the current number to the window's sum
            currentSum += currentNum;

            // If we found a duplicate within the current window
            if (indexMap.containsKey(currentNum) && indexMap.get(currentNum) >= left) {
                // Find the previous index of the duplicate
                int prevIndex = indexMap.get(currentNum);
                
                // Subtract all numbers from the left up to that duplicate's position
                for (int i = left; i <= prevIndex; i++) {
                    currentSum -= nums[i];
                }
                
                // Move the left pointer past the duplicate
                left = prevIndex + 1;
            }
            
            // Update the number's last seen index
            indexMap.put(currentNum, right);
            
            // Update the max sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}