/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] pathArray = new int[1];
        pathArray[0]=Integer.MIN_VALUE;
        toFindPathSum(root,pathArray);
        return pathArray[0];
    }
    public int toFindPathSum(TreeNode root,int[] arr){
        if(root==null)
            return 0;
         int leftSum = Math.max(0,toFindPathSum(root.left,arr)); 
         // For avoiding the negative values we are using Math.max(0,root.left);
         int rightSum = Math.max(0,toFindPathSum(root.right,arr));
        
         arr[0]=Math.max(arr[0],leftSum+rightSum+root.val);
        
         return Math.max(leftSum,rightSum)+root.val;
        // to find which path have to consider ... we have to find the maximum value path ,so that's why we are finding Math.max(left,right);
    }
}
/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
*/
