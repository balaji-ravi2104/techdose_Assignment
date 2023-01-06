class Solution {
    public int countSubstrings(String s) {
        int ans = 0;        
        for(int i = 0; i< s.length();i++){
            ans += countP(s,i,i);//odd extention
            ans += countP(s,i,i+1);//even extention
        }
        return ans;
    }    
    int countP(String s, int l,int r){
        int currCount = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            currCount +=1;
            l--;
            r++;
        }
        return currCount;
    }
}
/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
