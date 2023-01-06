class Solution {
		public String shortestCommonSupersequence(String str1, String str2) {
			int[][] dp = new int[str1.length() +1][str2.length()+1];

			for(int i = 0; i <= str1.length(); i++) {
				for(int j = 0; j <= str2.length(); j++) {
					if(i == 0 || j == 0) 
                        dp[i][j] = 0;
					else if(str1.charAt(i-1) == str2.charAt(j-1)) {
						dp[i][j] = 1 + dp[i-1][j-1];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}

			int i = str1.length();
			int j = str2.length();
			StringBuilder result = new StringBuilder();

			while(i > 0 && j > 0) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					result.append(str1.charAt(i-1));
					i--;
					j--;
				} else if( dp[i-1][j] > dp[i][j-1] ) {
					result.append(str1.charAt(i-1));
					i--;
				} else {
					result.append(str2.charAt(j-1));
					j--;
				}
			}
			while(i > 0) {
			   result.append(str1.charAt(i-1));
				i--; 
			}
			while(j > 0) {
			   result.append(str2.charAt(j-1));
				j--; 
			}

			return result.reverse().toString();
		}
	}
/* Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
*/
