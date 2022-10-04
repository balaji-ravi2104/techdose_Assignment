class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length,res=n+1;
        long[] arr = new long[n+1];
        for(int i=0;i<n;i++){
            arr[i+1]=arr[i]+nums[i];
        }
        Deque<Integer> d = new ArrayDeque<>();
        for(int i=0;i<n+1;i++){
            while(d.size()>0 && arr[i]-arr[d.getFirst()]>=k)
                res=Math.min(res, i - d.pollFirst());
            while(d.size()>0 && arr[i]<=arr[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res<=n ?res:-1;
    }
}
/*
Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3
*/
