class Solution {
    class TrieNode{
    Map<Character,TrieNode> map = new HashMap<>();
    boolean isWord = false;
    }
    TrieNode trie = new TrieNode();
    List<String> ans = new LinkedList<>();
    char[][] board;
    boolean[][] visited;
    int n,m;
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            insertWord(word);
        }
        this.m=board.length;
        this.n=board[0].length;
        this.board=board;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch=board[i][j];
                visited=new boolean[m][n];
                dfs(i,j,new StringBuilder(),trie);
            }
        }
        return ans;
    }
    private void dfs(int i,int j,StringBuilder sb,TrieNode curTrie)
    {
        if(i<0 || i>=m || j>=n || j<0) return;

        if(visited[i][j]) return;
        
        char ch=board[i][j];
        if(!curTrie.map.containsKey(ch))
            return;

        sb.append(ch);
        curTrie = curTrie.map.get(ch);
        visited[i][j]=true;

        if(curTrie.isWord){
            ans.add(sb.toString());
            curTrie.isWord=false;
        }

        dfs(i,j+1,sb,curTrie);
        dfs(i+1,j,sb,curTrie);
        dfs(i,j-1,sb,curTrie);
        dfs(i-1,j,sb,curTrie);

        sb.setLength(sb.length()-1);
        visited[i][j]=false;
    }
    private void insertWord(String word){
        char[] arr = word.toCharArray();
        TrieNode currNode = trie;
        for(char ch:arr){
            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch,new TrieNode());
            }
            currNode=currNode.map.get(ch);
        }
        currNode.isWord = true;
    }
}
/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
