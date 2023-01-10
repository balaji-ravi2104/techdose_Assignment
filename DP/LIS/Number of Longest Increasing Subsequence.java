class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] lis=new int[nums.length];
        int result=1;
        lis[0]=1;
        int[] cut = new int[nums.length];
        Arrays.fill(cut , 1);
        for(int i=1;i<nums.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && lis[i]<=lis[j]){
                    lis[i]=lis[j]+1;
                    cut[i] = cut[j];
                }
                else if(lis[j]+1 == lis[i]){
                    cut[i]+=cut[j];
                }
                result=Math.max(result,lis[i]);
            }
        }
        //System.out.println(result);
        int count=0;
        for(int i=0;i<lis.length;i++){
            if(lis[i]==result){
                count=count+cut[i];
            }
        }
        return count;
    }
}
/*
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
*/
