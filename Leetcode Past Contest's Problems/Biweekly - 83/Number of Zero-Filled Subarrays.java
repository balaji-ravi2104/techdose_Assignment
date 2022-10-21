class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long  ans=0,numSubarray=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                numSubarray++;
            else
                numSubarray=0;
            ans+=numSubarray;
        }
        return ans;
    }
}
