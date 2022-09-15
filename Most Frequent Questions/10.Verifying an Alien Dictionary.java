class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            
            int size=Math.min(word1.length(),word2.length());
            int j=0;
            boolean flag=false;
            while(j<size){
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
                if(map.get(c1)>map.get(c2))
                    return false;
                else if(map.get(c1)<map.get(c2)){
                    flag=true;
                    break;
                }
                 j++;   
            }
        if(!flag && word1.length()>word2.length())
            return false;
        }
        return true;
    }
}

/*  
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character 
