public class Solution{
  public boolean findPath(TreeNode node, ArrayList<Integer> arr,int x){
    if(node==null)
      return false;
    
    arr.add(node.val);
    
    if(node.val==x)
      return true;
    
    if(findPath(node.left,arr,x) || findPath(node.right,arr,x))
      return true;
    
    arr.remove(arr.size()-1);
    return false;
  }
  public ArrayList<Integer> solve(TreeNode A,int B){
    ArrayList<Integer> list = new ArrayList<>();
    if(A==null)
      return list;
    findPath(A,list,B);
    return list;
  }
}
/*
Given a root of a node we have to find the path from root to the given destination and return the list of values

input:
node=[1,2,3,4,5,6,7,8,9]
destination = 2

output:
[1,2]
