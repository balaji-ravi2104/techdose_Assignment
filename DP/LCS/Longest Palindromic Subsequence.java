// Tabulation
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        String rev = new StringBuilder(s).reverse().toString();// take same given string with reverse order Eg : bbbab as babbb then same code of LCS
        int[][]dp=new int[len+1][len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }
}
// recrusion with memozition
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len1=s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int len2=rev.length();
        int[][] memo = new int[len1+1][len2+1];
        for(int[] arr :memo){
            Arrays.fill(arr,-1);
        }
        return toFindSequence(s,rev,len1,len2,memo);
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
/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no 
elements without changing the order of the remaining elements.


Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
*/
