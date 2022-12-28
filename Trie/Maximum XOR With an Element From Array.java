class Node{
    Node[] links = new Node[2];
    public Node(){

    }
    public boolean containsKey(int bit){
        return(links[bit]!=null);
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie obj = new Trie();
        int queriesLength = queries.length;
        int[] ans = new int[queriesLength];
        int[][] temp = new int[queriesLength][3];
        for (int i = 0; i < queriesLength; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(temp, (a, b) -> {
            return a[1] - b[1];
        });
        int index = 0;
        Arrays.sort(nums);

        for(int query[]:temp){
            while(index<nums.length && nums[index]<=query[1]){
                obj.insert(nums[index]);
                index++;
            }
            int tempAns=-1;
            int x=query[0];
            if(index!=0){
                tempAns = Math.max(tempAns,obj.getMax(x));
            }
            ans[query[2]] = tempAns;
        }
        return ans;
    }
}
/*
You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, 
the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.

 

Example 1:

Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
Output: [3,3,7]
Explanation:
1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
Example 2:

Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
Output: [15,-1,5]
 

Constraints:

1 <= nums.length, queries.length <= 105
queries[i].length == 2
0 <= nums[j], xi, mi <= 10^9
*/
