class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res=1,j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[j]>k)
            {
                res++;
                j=i;
            }
        }
        return res;
    }
}
