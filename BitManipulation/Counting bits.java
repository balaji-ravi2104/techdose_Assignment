class Solution {
    public int[] countBits(int n) {
        int[] nums=new int[n+1];
        for(int i=1;i<=n;i++){
            int count=0;
            int bit=i;
            while(bit!=0){
                if((bit&1)==1){
                count++;
                }
                bit>>=1;
            }
            nums[i]=count;
        }
        return nums;
    }
}