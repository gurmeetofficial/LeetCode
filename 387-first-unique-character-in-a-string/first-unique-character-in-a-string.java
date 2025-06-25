class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c:s.toCharArray()) {
            count[c-'a']++;
        }
        int itr=0;
        for(char c:s.toCharArray()) {
            if (count[c-'a']==1) return itr;
            itr++;
        }
        return -1;
    }
}