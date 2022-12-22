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
 /*
 
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        preorder(root,list);
        //System.out.print(list);
        for(int i=1;i<list.size();i++){
            root.left=null;
            root.right=new TreeNode(list.get(i));
            root=root.right;
        }
    }
    public void preorder(TreeNode root,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }
}
/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
*/
/*
