class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> myList = new ArrayList<>();
        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;
        
        while(left <= right && top <= bottom)
        {
            for(int i = left; i <= right; i++)
                myList.add(matrix[top][i]);
            top++;
            
			for(int i = top; i <= bottom; i++)
                myList.add(matrix[i][right]);
            right--;
            
            if(left > right || top > bottom)    break;
            
            for(int i = right; i >= left; i--)
                myList.add(matrix[bottom][i]);
            bottom--;
            
            for(int i = bottom; i >= top; i--)
                myList.add(matrix[i][left]);
            left++;
        }
        return myList;
    }
}
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
