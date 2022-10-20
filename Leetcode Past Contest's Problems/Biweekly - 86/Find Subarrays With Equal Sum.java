class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> s = new HashSet();
        for(int i=0;i<nums.length-1;i++){
            s.add(nums[i]+nums[i+1]);
        }
        return s.size() != nums.length-1;
    }
}
