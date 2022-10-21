class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
            gcd=toFindGCD(gcd,numsDivide[i]);
        }
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(gcd%nums[i]==0)
                return count;
            else
                count++;
        }
        return -1;
    }
    public static int toFindGCD(int a,int b){
        if(b==0)
            return a;
        return toFindGCD(b,a%b);
    }
}
