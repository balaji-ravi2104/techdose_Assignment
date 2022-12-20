/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void createParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
                parent.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                parent.put(curr.right,curr);
            }
        }

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         Map<TreeNode,TreeNode> parent = new HashMap<>();
         createParent(root,parent);
         Map<TreeNode,Boolean> visited = new HashMap<>();
         Queue<TreeNode> que = new LinkedList<>();
         que.offer(target);
         visited.put(target,true);
         int level=0;
         while(!que.isEmpty()){
             int size=que.size();
             if(level==k){
                 break;
             }
             level++;
             for(int i=0;i<size;i++){
                 TreeNode curr = que.poll();
                 if(curr.left!=null && visited.get(curr.left)==null){
                     que.offer(curr.left);
                     visited.put(curr.left,true);
                 }
                 if(curr.right!=null && visited.get(curr.right)==null){
                     que.offer(curr.right);
                     visited.put(curr.right,true);
                 }
                 if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                     que.offer(parent.get(curr));
                     visited.put(parent.get(curr),true);
                 }
             }
         }
         List<Integer> list = new ArrayList<>();
         while(!que.isEmpty()){
             TreeNode temp = que.poll();
             list.add(temp.val);
         }
         return list;
    }
}
/*
iven the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a 
distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
*/
