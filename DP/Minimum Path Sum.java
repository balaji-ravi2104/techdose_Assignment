class Solution {
    public int minPathSum(int[][] nums) {
        // TC --> O(row*col);
        // SC --> O(1) // we are not using any extra space
        int row=nums.length;
        int col=nums[0].length;
        if(row==0){
            return 0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0)
                    nums[i][j]=nums[i][j];
                else if(i==0 && j!=0)
                    nums[i][j]=nums[i][j]+nums[i][j-1];
                else if(i!=0 && j==0)
                    nums[i][j]=nums[i][j]+nums[i-1][j];
                else
                    nums[i][j]=nums[i][j]+Math.min(nums[i-1][j],nums[i][j-1]);
            }
        }
        return nums[row-1][col-1];
    }
}
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/
