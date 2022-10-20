class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int val=0;
      for(int i=0;i<nums.length;i++)
      {
          if(Math.abs(0-nums[i])<=min){
              min=Math.abs(0-nums[i]);
              val=nums[i];
          }
      }
      return val;
    }
}
