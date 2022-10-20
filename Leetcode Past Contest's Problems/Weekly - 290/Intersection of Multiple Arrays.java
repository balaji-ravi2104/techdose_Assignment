class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                count[nums[i][j]]++;
            }
        }
        for(int i=0;i<=1000;i++){
            if(count[i]==nums.length)
                list.add(i);
        }
        return list;
    }
}
