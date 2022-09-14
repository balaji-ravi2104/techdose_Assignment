class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        int[] arr=new int[2];
        
        for(int i=0;i<nums.length;i++){
            
            int c=target-nums[i];
            
            if(!map.containsKey(nums[i])){
                map.put(c,i);
            }
            else{
                arr[0]=map.get(nums[i]);
                arr[1]=i;
            }
        }
        return arr;
    }
}
