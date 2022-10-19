class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            int val=reverse(nums[i]);
            set.add(val);
        }
        return set.size();
    }
    public static int reverse(int num){
        String s=Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        String str=sb.reverse().toString();
        int n=Integer.parseInt(str);
        return n;
    }
}
