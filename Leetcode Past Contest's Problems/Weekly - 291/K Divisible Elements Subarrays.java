class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int len=nums.length,count=0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            int countK=0;
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<len;j++){
                sb.append(nums[j]+" ");
                if(nums[j]%p==0)
                    countK++;
                if(countK>k)
                    break;
                if(!set.contains(sb.toString())){
                    count++;
                    set.add(sb.toString());
                }
            }
        }
        return count;
    }
}
