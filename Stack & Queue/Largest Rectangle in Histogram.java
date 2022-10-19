class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        if (height == null || n == 0) {
            return 0;
        }
        int[] left = new int[n]; 
        int[] right = new int[n];
        left[0] = -1;
        right[n- 1] = n;
        int ans = 0;
        for(int i = 1; i < n; i++){
            int a = i - 1;
            while(a >= 0 && height[a] >= height[i]) a  = left[a];
                left[i] = a;
        }
        for(int i = n - 2; i >= 0; i--){
            int b = i + 1;
            
            while(b < height.length && height[b] >= height[i]) 
                b = right[b];
            right[i] = b;
        }
        for(int i = 0; i < n; i++) 
            ans = Math.max(ans, height[i] * (right[i] - left[i] - 1));

        return ans;
    }
}
/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.
Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:

Input: heights = [2,4]
Output: 4
 
Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
