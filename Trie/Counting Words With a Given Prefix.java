class Node{
    Node[] links = new Node[26];
    int cntEndWith=0;
    int cntPrefix=0;
   public Node(){
        
    }
    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void increaseEnd(){
        cntEndWith++;
    }
    public void increasePrefix(){
        cntPrefix++;
    }
    public int getPrefix(){
        return cntPrefix;
    }
}
class Solution {
    Node root = new Node();
    public int prefixCount(String[] words, String pref) {
        for(String word:words)
        {
            insert(word);
        }
        return countWordsStartingWith(pref);
    }
    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }
}
/*
You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

 

Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
*/
