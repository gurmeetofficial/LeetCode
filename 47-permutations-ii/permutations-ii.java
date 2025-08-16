class Solution {
    List<List<Integer>> res;
    Set<String> trackPairs = new HashSet<>();
    private void swap(List<Integer> itr, int left, int right) {
        int temp = itr.get(left);
        itr.set(left, itr.get(right));
        itr.set(right, temp);
    }

    private void permuteUniqueRec (int[] nums, int startIndex, List<Integer> itr) {
        String str = itr.toString();
        if(trackPairs.contains(str)) {
            return;
        }
        int len = nums.length;
        if(startIndex>len-1) {
            res.add(itr);
            trackPairs.add(str);
            return;
        }
        for(int i=startIndex;i<len;i++) {
            permuteUniqueRec(nums, startIndex+1, new LinkedList<>(itr));
            swap(itr, startIndex, i);
            permuteUniqueRec(nums, startIndex+1, new LinkedList<>(itr));
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        List<Integer> itr = Arrays.stream(nums) // Create an IntStream
                                        .boxed()           // Convert int primitives to Integer objects
                                        .collect(Collectors.toList()); // Collect into a List

        permuteUniqueRec(nums, 0, itr);
        return res;
    }
}