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
        return count;
    }
}

/* 
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

*/
