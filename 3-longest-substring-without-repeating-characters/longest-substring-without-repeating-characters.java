class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int curLen=0, maxLen=0;
        int left=0, right=0;
        int len = s.length();
        Character curChar;
        while(right<len) {
            curChar=s.charAt(right);
            if(map.containsKey(curChar) && map.get(curChar)>0) {
                while(left<right) {
                    Character prevChar = s.charAt(left);
                    left++;
                    if(prevChar.equals(curChar)) {
                        curLen=right-left+1;
                        break;
                    } else {
                        map.put(prevChar, map.getOrDefault(prevChar, 0)-1);
                    }
                }
            } else {
                map.put(curChar, map.getOrDefault(curChar, 0)+1);
                curLen+=1;
                maxLen = Math.max(maxLen, curLen);
            }
            right++;
        }
        return maxLen;
    }
}