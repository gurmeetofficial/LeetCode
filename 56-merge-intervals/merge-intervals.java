class Solution {
    private int getNextIndex (int[][] intervals, int curIndex) {
        int len = intervals.length;
        int nextIndex = curIndex+1;
        while(nextIndex<len) {
            if(intervals[curIndex][1]>=intervals[nextIndex][0]) {
                intervals[curIndex][1] = Math.max(intervals[curIndex][1], intervals[nextIndex][1]);
                nextIndex++;
            } else break;
        }
        return nextIndex-1;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int len = intervals.length;
        List<Integer[]>list = new LinkedList<>();
        for(int i=0;i<len;i++) {
            Integer[] temp = new Integer[2];
            temp[0]=intervals[i][0];
            int nextIndex = getNextIndex(intervals, i);
            System.out.println(nextIndex);
            temp[1] = Math.max(intervals[nextIndex][1], intervals[i][1]);
            i=nextIndex;
            list.add(temp);
            System.out.println(intervals[i][0]);
        }
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++) {
            res[i][0]=list.get(i)[0];
            res[i][1]=list.get(i)[1];
        }
        return res;
    }
}