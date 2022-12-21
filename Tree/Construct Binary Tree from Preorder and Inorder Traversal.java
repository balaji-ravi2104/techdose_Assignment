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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        // put all the inorder values into map keys are values and index's are values;
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

        return root;
    }
    public static TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
            if((preStart>preEnd || inStart>inEnd)){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);// create a new node and add the root value
            int inRoot = map.get(root.val);// Find the index of the root.val in inorder array;
            int numLeft = inRoot - inStart;// Find the number of elements towards left to the inRoot

               root.left = buildTree(preorder,preStart+1,preStart+numLeft,inorder,inStart,inRoot-1,map); // create a left subTree by calling recursive function 

               root.right= buildTree(preorder,preStart+numLeft+1,preEnd,inorder,inRoot+1,inEnd,map); // create a right subTree by calling recursive function

               return root;
    }
}
/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
*/
