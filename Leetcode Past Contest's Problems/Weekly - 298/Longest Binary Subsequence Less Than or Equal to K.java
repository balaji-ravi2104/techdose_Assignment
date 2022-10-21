class Solution {
    public int longestSubsequence(String s, int k) {
        int sum=0,ones=0,zero=0,len=s.length();
        for(int i=len-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='0')
                zero++;
            else{
                sum+=Math.pow(2,len-1-i);
                if(sum<=k)
                    ones++;
            }
        }
        return ones+zero;
    }
}
