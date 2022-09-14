/* You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
/*Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps*/

class Solution {
    public int climbStairs(int n) {
        int a=0,b=1,i=0,c=0;
       while(i<n){
        c = a+b;
        a=b;
        b=c;
        i++;
      }
    return c;
    }
}
