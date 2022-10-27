class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int len1=s.length();
        int len2=p.length();

        int[] alpha=new int[26];

        for(char ch:p.toCharArray()){
            alpha[ch-'a']++;
        }

        String pat=Arrays.toString(alpha);

        List<Integer>arr=new ArrayList<>();
        for(int i=0;i<=len1-len2;i++){

            String sub=s.substring(i,i+len2);
            int[] all=new int[26];

            for(char c:sub.toCharArray()){
                all[c-'a']++;
            }

            String match=Arrays.toString(all);
            if(match.equals(pat)){
                arr.add(i);
            }
        }

        return arr;
    }
}
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
