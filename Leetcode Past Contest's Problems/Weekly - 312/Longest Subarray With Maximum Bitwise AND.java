class Solution {
    public int longestSubarray(int[] nums) {
        int ans=1,max=0,current=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        for(int i:nums){
            if(i==max){
                ans=Math.max(ans,++current);
            }else{
                current=0;
            }
        }
        return ans;
    }
}
