class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        int ans=-1;
        int minAvg = Integer.MAX_VALUE;
        
        long[] prefix = new long[n+1];
        long[] suffix = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }
        for(int i=0;i<n;i++){
            long left = prefix[i+1];
            left/=(i+1);
            
            long right=suffix[i+1];
            if(i!=n-1){
                right/=(n-i-1);
            }
            int diff=(int)Math.abs(left-right);
            if(diff<minAvg){
                minAvg=diff;
                ans=i;
            }
        }
        return ans;
    }
}
