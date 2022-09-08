class Solution {
    public int singleNumber(int[] nums) {
    int first = 0;
    int second = 0;
    
    for (int i = 0; i < nums.length; i++) {
        first = first ^ nums[i] & (~second);
        second = second ^nums[i] & (~first);
    }
     
    return first;
    }
}