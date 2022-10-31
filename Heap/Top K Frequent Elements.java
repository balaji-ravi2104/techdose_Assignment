class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int num:nums){
           map.put(num,map.getOrDefault(num,0)+1);
       }
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list,(a,b) -> map.get(b) - map.get(a));
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
*/
