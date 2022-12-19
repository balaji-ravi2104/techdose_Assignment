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
 class pair{
    TreeNode node;
    int num;
    pair(TreeNode _node,int _num){
        node=_node;
        num=_num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int ans=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int minn=q.peek().num;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int cur_id = q.peek().num-minn;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0)
                    first = cur_id;
                if(i==size-1)
                    last = cur_id;
                    
                if(node.left!=null){
                    q.offer(new pair(node.left,cur_id*2+1));
                }
                if(node.right!=null){
                    q.offer(new pair(node.right,cur_id*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
/
Explanation: The maximum width exists in the second level with length 2 (3,2).
