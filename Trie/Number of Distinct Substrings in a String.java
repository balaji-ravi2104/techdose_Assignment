
import java.util.ArrayList;
class Node{
    Node[] links = new Node[26];
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
}
public class Solution 
{
	public static int countDistinctSubstrings(String s) 
	{
		Node root = new Node();
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            Node node = root;
            for(int j=i;j<len;j++){
                if(!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j),new Node());
                    count++;
                }
                node=node.get(s.charAt(j));
            }
        }
        return count+1;
	}
}
/*
Given a string of length N of lowercase alphabet characters. The task is to complete the function countDistinctSubstring(), 
which returns the count of total number of distinct substrings of this string.


2
ab
ababa

Output:
4
10

Exaplanation:
Testcase 1: For the given string "ab" the total distinct substrings are: "", "a", "b", "ab".
*/
*/
