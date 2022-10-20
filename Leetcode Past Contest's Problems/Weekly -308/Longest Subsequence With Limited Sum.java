class Solution {
    public int[] answerQueries(int[] nums, int[] q) {
    Arrays.sort(nums);
    for(int i=0; i<q.length; i++) {
        long sum = 0; int j = 0;
        for(j=0; j<nums.length; j++) {
            if(sum+nums[j]>q[i]){
                q[i] = j;
                break;
            }
            sum = sum+nums[j];
        }
        if(j==nums.length) 
            q[i] = j;
    }
    
        return q;
    }
}
