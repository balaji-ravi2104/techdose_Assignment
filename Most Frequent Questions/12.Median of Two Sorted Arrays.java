class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[] ans = new int[len1+len2];
        System.arraycopy(nums1, 0, ans, 0, len1);  
        System.arraycopy(nums2, 0, ans, len1, len2);
        Arrays.sort(ans);
        //System.out.println(Arrays.toString(ans));  
        int len=ans.length;
        if(len%2==0){
            int x=ans[len/2];
            int y=ans[(len/2)-1];
            return (x+y)/2.0;
        }else{
            return ans[(len/2)];
        }
    }
} 
/* 
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

*/
