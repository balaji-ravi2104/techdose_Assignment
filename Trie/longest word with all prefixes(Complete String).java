import java.util.* ;
import java.io.*; 
class Node{
    Node[] links = new Node[26];
    boolean flag=false;
    
    Node(){
        
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
    public void setEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class Trie{
    private static Node root;
    public Trie(){
        root = new Node();
     }
    
    public void insert(String word) {
        //initializing dummy node pointing to root initially
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            //moves to reference trie
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public static boolean checkifexistsPrefix(String word){
        Node node = root;
        boolean fl=true;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
                fl = fl & node.isEnd();
            }else{
            return false;
            }
        }
        return fl;
    }
}
class Solution {

  public static String completeString(int n, String[] a) {
      Trie obj = new Trie();
        for(String temp:a){
            obj.insert(temp);
        }
    
        String longest = "";
      for(String temp:a){
          if(obj.checkifexistsPrefix(temp)){
              if(temp.length()>longest.length()){
                  longest=temp;
              }
              else if(temp.length()==longest.length() && temp.compareTo(longest)<0){
                  longest=temp;
              }
          }
      }
      if(longest.equals("")){
          return "None";
      }
      return longest;
  }
}
/*
input:
6
n ni nin ninj ninja ninga

output:
ninja

input:
2
ab bc

output:
None

For test case 1 we have, 

All the prefixes of “ninja” -> “n”, “ni”, “nin”, “ninj” and “ninja” are present in array ‘A’. So, “ninja” is a valid answer whereas for “ninga” , 
the prefix “ning” is not present in array ‘A’.

So we output “ninja”.

For test case 2 we have, 

The prefixes of “ab” are “a” and “ab”. “a” is not present in array ‘A’. So, “ab” is not a valid answer.

The prefixes of “bc” are “b” and “bc”. “b” is not present in array ‘A’. So, “ab” is not a valid answer.

Since none of the strings is a valid answer we output “None”.
*/
