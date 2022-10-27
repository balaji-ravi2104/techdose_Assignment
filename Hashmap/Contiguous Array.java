class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0,len=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            count=count+(nums[i]==1?1:-1);
            if(map.containsKey(count)){
                len=Math.max(len,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return len;
    }
}
