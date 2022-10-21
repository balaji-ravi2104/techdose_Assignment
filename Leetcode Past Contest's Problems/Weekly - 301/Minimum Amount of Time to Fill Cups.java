class Solution {
    public int fillCups(int[] amount) {
        int max=0,sum=0;
        for(int x:amount){
            max=Math.max(x,max);
            sum+=x;
        }
        return Math.max(max,(sum+1)/2);
    }
}
