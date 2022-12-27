class TrieNode{
    public TrieNode[] links;
    private final int size=26;
    private boolean isEnd=false;
    public TrieNode(){
        links=new TrieNode[size];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node){
        links[ch-'a']=node;
    }
    public void setEnd(){
        isEnd=true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode());
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        return find(word.toCharArray(), node, 0);
    }
    
    private boolean find(char[] word,TrieNode node, int ind) {
        if(node == null) return false;
        if(ind == word.length) return node.isEnd();
        char ch = word[ind];
        if(ch == '.') {
            for(int i = 0; i< 26 ; i++) {
                if (node.links[i] != null && find(word, node.links[i], ind+1)) {
                    return true;
                }
            }
             
        } else {
            return node.links[ch - 'a'] != null && find(word, node.links[ch - 'a'], ind+1);
        }
        return false;
    }
}
/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/
