class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int result = 1;
        for(int i = 1; i < nums.length; i++){
            lis[i]=1;
            for (int j = 0; j < i; j++){
                if(nums[i] > nums[j] && lis[i] <= lis[j])
                    lis[i]=lis[j]+1;
                if(lis[i]>result)
                    result=lis[i];
            }
        }
        // int c=result;
        // for(int i=nums.length-1;i>=0;i--){
        //     if(lis[i]==c){
        //         c--;
        //         System.out.print(nums[i]+" ");
        //     }
        // } just for lis array priniting
        return result;
    }
}
/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/
