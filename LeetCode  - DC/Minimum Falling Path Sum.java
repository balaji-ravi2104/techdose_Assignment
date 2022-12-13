class Solution {
	public int minFallingPathSum(int[][] A) {

		for (int i=1; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				A[i][j] += minOfThree(A, i-1, j);
			}
		}

		int res = Integer.MAX_VALUE;
		for (int m = 0; m < A.length; m++) {
			res = Math.min(res, A[A.length - 1][m]);
		}

		return res;
	}

	private int minOfThree(int[][] A, int i, int j) {
		int min = A[i][j];

		if (j > 0) {
			min = Math.min(min, A[i][j-1]);
		}

		if (j < A.length - 1) {
			min = Math.min(min, A[i][j+1]);
		}
        //System.out.println(min+" ");
		return min;
	}
}
/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either 
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be 
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
*/
