class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans=0;
        for(int val:tasks)
            map.put(val,map.getOrDefault(val,0)+1);
        for(int count:map.values()){
            if(count==1)
                return -1;
            ans+=(count+2)/3;
        }
        return ans;
    }
}
