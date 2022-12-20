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
    public List<Integer> minimumTimeToBurn(TreeNode root, TreeNode target, int k) {
         Map<TreeNode,TreeNode> parent = new HashMap<>();
         createParent(root,parent);
         Map<TreeNode,Boolean> visited = new HashMap<>();
         Queue<TreeNode> que = new LinkedList<>();
         que.offer(target);
         visited.put(target,true);
         int level=0;
         int time=0;
         while(!que.isEmpty()){
             int size=que.size();
             int flag=0;
             for(int i=0;i<size;i++){
                 TreeNode curr = que.poll();
                 if(curr.left!=null && visited.get(curr.left)==null){
                     flag=1;
                     que.offer(curr.left);
                     visited.put(curr.left,true);
                 }
                 if(curr.right!=null && visited.get(curr.right)==null){
                     flag=1;
                     que.offer(curr.right);
                     visited.put(curr.right,true);
                 }
                 if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                     flag=1;
                     que.offer(parent.get(curr));
                     visited.put(parent.get(curr),true);
                 }
             }
             if(flag==1){
                 time++;
             }
         }
         return time;
    }
}
/*
Given a binary tree and find the minimum time to burn the entire tree and return the time. The root of the node and the starting point of the node will be given.

intput: tree=[1,2,3,null,null,4,5]
        starting node = 3

output: 2
*/
