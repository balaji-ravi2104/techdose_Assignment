class Solution {
    public String longestPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            String s1=isPalindrome(s,i,i);
            String s2=isPalindrome(s,i,i+1);
            res=res.length()>s1.length()?res:s1;
            res=res.length()>s2.length()?res:s2;
        }
        return res;
    }
    public String isPalindrome(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}

/*  Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb" 
*/
