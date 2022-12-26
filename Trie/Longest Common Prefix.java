class Node{
    Node[] links = new Node[26];
    boolean flag=false;
    int count=0;
    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    public void put(char ch,Node node){
        links[ch-'a']=node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for(int i=0;i<strs.length;i++){
            insert(strs[i],root);
        }
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for(int i=0;i<strs[0].length();i++){
            if((findCount(strs[0].charAt(i),node))==strs.length){
                sb.append(strs[0].charAt(i));
                node=node.get(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
    public void insert(String word,Node node) {
        //initializing dummy node pointing to root initially
        //Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            //moves to reference trie
            node=node.get(word.charAt(i));
            node.count++;
        }
    }
    public int findCount(char ch,Node node){
        return node.links[ch-'a'].count;
    }
}
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.*/
