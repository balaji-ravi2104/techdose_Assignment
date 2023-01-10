// tabulation
public class Solution {
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
// recrusion with memozation

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] memo = new int[n][amount+1];
        for(int[] row: memo){
            Arrays.fill(row,-1);
        }
        int res=toFindCount(n-1,amount,coins,memo);
        if(res>=1e9){
            return -1;
        }
        return res;
    }
    public static int toFindCount(int ind,int amount,int[] coins,int[][] memo){
        if(ind==0){
            if(amount % coins[0]==0) // finding the denominations
                return amount/coins[0];
            else 
                return (int)1e9;
        }
        if(memo[ind][amount]!=-1){
            return memo[ind][amount];
        }

        int notTake=0+toFindCount(ind-1,amount,coins,memo);

        int take=Integer.MAX_VALUE;
        if(coins[ind]<=amount)
            take=1+toFindCount(ind,amount-coins[ind],coins,memo);

        return memo[ind][amount]=Math.min(notTake,take);
    }
}
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
*/
