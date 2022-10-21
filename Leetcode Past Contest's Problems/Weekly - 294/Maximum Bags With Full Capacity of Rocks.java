class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count=0,len=capacity.length;
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            ans[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(ans);
        for(int i=0;i<len;i++){
            if(ans[i]<=additionalRocks){
                additionalRocks-=ans[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
