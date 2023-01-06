// recrusion with memozitation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] memo = new int[len1+1][len2+2];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return toFindSequence(text1,text2,len1,len2,memo);
    }
    public static int toFindSequence(String s1,String s2,int m,int n,int[][] memo){
        if(m==0 || n==0)
        {
            return 0;
        }
        if(memo[m][n]!=-1){
            return memo[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return memo[m][n]=1+toFindSequence(s1,s2,m-1,n-1,memo);
        }
        else{
            return memo[m][n]=Math.max(toFindSequence(s1,s2,m-1,n,memo),toFindSequence(s1,s2,m,n-1,memo));
        }
    }
}
//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        char[] ch1 =text1.toCharArray();
        char[] ch2 =text2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];
        int i,j;
        for(i=0;i<=len1;i++){
            for(j=0;j<=len2;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(ch1[i-1]==ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing 
the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/
