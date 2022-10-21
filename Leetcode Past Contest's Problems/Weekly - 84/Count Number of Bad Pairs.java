class Solution {
    public long countBadPairs(int[] nums) {
        long count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int d=i-nums[i];
            if(map.containsKey(d))
                count+=(i-map.get(d));
            else
                count+=i;
            map.put(d,map.getOrDefault(d,0)+1);
        }
        return count;
    }
}
