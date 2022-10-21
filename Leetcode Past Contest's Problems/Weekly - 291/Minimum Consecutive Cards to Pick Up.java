class Solution {
    public int minimumCardPickup(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                min=Math.min((i-map.get(nums[i]))+1,min);
            map.put(nums[i],i);
        }
        return min!=Integer.MAX_VALUE?min:-1;
    }
}
