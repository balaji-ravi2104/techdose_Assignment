class Node{
    Node[] links = new Node[2];
    public Node(){

    }

    public boolean containsKey(int bit){
        return (links[bit]!=null);
    }

    public Node get(int bit){
        return links[bit];
    }

    public void put(int bit,Node node){
        links[bit]=node;
    }
}
class Trie{
    private static Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1; // to check the ith index set or Not
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }

    public int getMax(int num){
        Node node = root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1; 
            if(node.containsKey(1-bit)){
              /* for xor operation we need opposite bit only ... 
              for example if we have 0 then we have to xor with 1 similarly 1 for 0.. so that's why 1 - bit..*/
                maxNum = maxNum | (1<<i); // to get the maximum 
                node = node.get(1-bit);
            }else{
                node=node.get(bit);
            }
        }
        return maxNum;
    }

}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj = new Trie();
        for(int n:nums){
            obj.insert(n);
        }
        int ans = 0;
        for(int n:nums){
            ans=Math.max(ans,obj.getMax(n));
        }
        return ans;
    }
}
/*
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1
*/
