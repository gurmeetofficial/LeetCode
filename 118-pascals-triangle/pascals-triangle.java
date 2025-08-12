class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> itr = new LinkedList<>();
        itr.add(1);
        res.add(itr);
        for(int i=1;i<numRows;i++) {
            itr = new LinkedList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) {
                    itr.add(1);
                } else {
                    itr.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
            }
            res.add(itr);
        }
        return res;
    }
}