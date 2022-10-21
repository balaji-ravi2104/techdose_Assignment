class Solution {
    public int maximumSum(int[] nums) {
        int result=-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=digitSum(nums[i]);
            if(!map.containsKey(key))
                map.put(key,nums[i]);
            else{
                result=Math.max(result,map.get(key)+nums[i]);
                map.put(key,Math.max(map.get(key),nums[i]));
            }
        }
        return result;
    }
    public static int digitSum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
