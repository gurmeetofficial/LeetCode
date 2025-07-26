class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        long cost = 0;
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                int j = i;
                List<Integer> group = new ArrayList<>();
                while (!visited[j]) {
                    visited[j] = true;
                    group.add(arr[j]);
                    j = (j + k) % len;
                }
                Collections.sort(group);
                int median = group.get(group.size() / 2);
                for (int ele : group) {
                    cost += Math.abs((long) ele - median);
                }
            }
        }
        return cost;
    }
}