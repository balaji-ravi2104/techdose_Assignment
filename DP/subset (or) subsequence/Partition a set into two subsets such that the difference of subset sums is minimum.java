import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        int k=totalSum;
        boolean dp[][]= new boolean[n][k+1];
        for(int i=0; i<n; i++){ // setting first coloum true;
        dp[i][0] = true;
        }
    
    if(arr[0]<=k) // if the first element is less than or equal to target then only that is true
        dp[0][arr[0]] = true;
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){
            
            boolean notTaken = dp[ind-1][target];
    
            boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];
        
            dp[ind][target]= notTaken||taken;
        }
    }
    int ans=Integer.MAX_VALUE;
    for(int i=0;i<=k/2;i++){
        if(dp[n-1][i]==true){
            ans=Math.min(ans,(Math.abs(k-i)-i));
        }
    }
    return ans;
	}
}
/*
I/P:
4
[1 2 3 4]
O/P:
0

where,
    We can partition the given array into {2,3} and {1,4}, as this will give us the minimum possible absolute difference i.e (5-5=0) in this case.
*/
