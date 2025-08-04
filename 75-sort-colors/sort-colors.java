class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ind=0;
        int countR=0, countW=0;
        while(ind<len) {
            if(nums[ind]==0) countR+=1;
            else if(nums[ind]==1) countW+=1;
            ind++;
        }
        ind=0;
        while(ind<len) {
            if(ind<countR) nums[ind]=0;
            else if(ind<countR+countW) nums[ind]=1;
            else nums[ind]=2;
            ind++;
        }
    }
}