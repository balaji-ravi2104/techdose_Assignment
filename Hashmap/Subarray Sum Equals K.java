class Solution {
    public int subarraySum(int[] nums, int k) {
       int n=nums.length;
        if(n==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int i=0;
        int count=0;
        int currSum=0;
        while(i<n){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
            i++;
        }
        System.out.println(map);
        return count;
    }
}
