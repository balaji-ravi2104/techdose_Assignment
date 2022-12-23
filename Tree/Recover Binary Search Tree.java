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
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && (root.val<prev.val)){
            if(first==null){// if first violation store the prev and current nodes
                first=prev;
                middle=root;
            }
            else{
                last=root;// if second violation just store that particular node
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        inorder(root);// while doing inorder if any two values are violated then store the nodes and swap the value..
        if(first!=null && last!=null){ // if two nodes are not adjecent
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if(first!=null && middle!=null)// if two nodes are adjecent
        {
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }
}
/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. 
Recover the tree without changing its structure.
Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
*/
