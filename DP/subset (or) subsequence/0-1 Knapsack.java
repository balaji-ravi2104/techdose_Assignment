// recrusion with memozation
public class Solution{
    public static int toFindMax(int ind,int maxWeight,int[] weight,int[] value,int[][] memo){
    if(ind==0){
        if(weight[0]<=maxWeight){
            return value[0];
        }
        else{
            return 0;
        }
    }
    if(memo[ind][maxWeight]!=-1){
        return memo[ind][maxWeight];
    }
    int notTake=0+toFindMax(ind-1,maxWeight,weight,value,memo);
    
    int Take=Integer.MIN_VALUE;
        
    if(weight[ind]<=maxWeight)
        Take=value[ind]+toFindMax(ind-1,maxWeight-weight[ind],weight,value,memo);
    
    return memo[ind][maxWeight]=Math.max(Take,notTake);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight)     {
    int[][] memo = new int[n][maxWeight+1];
    for(int[] row:memo){
    Arrays.fill(row,-1);
    }
    return toFindMax(n-1,maxWeight,weight,value,memo);

    }
}
// Tabulation

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight){
    int[][] dp = new int[n][maxWeight+1];
    for(int i=weight[0];i<=maxWeight;i++){
        dp[0][i]=value[0];
    }
    for(int ind=1;ind<n;ind++){
        for(int W=0;W<=maxWeight;W++){
            int notTake=0+dp[ind-1][W];
    
            int Take=Integer.MIN_VALUE;
            if(weight[ind]<=W)
                Take=value[ind]+dp[ind-1][W-weight[ind]];
    
            dp[ind][W]=Math.max(Take,notTake);
        }
    }
    return dp[n-1][maxWeight];
    }
}
/*
A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. 
Considering the constraints of the maximum weight that a knapsack can carry,  you have to find and return the maximum value that a thief can 
generate by stealing items.
input:
4
1 2 4 5 ---> weight
5 4 8 6 ---> value
5
output:
13
*/
