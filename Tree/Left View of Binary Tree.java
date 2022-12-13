/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> list = new ArrayList<>();
      if(root==null)
        return list;
        
      dfs(root,list,0);
      return list;
    }
    
    public static void dfs(Node root,ArrayList<Integer> list,int count){
        if(root==null)
        {
            return;
        }
        if(count==list.size()){
            list.add(root.data);
        }
        dfs(root.left,list,count+1);
        dfs(root.right,list,count+1);
    }
}
/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /   \
  4     5   6       7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3
