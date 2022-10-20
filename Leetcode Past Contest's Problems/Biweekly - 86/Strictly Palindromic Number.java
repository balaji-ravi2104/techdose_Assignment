class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2;i <= n-2;i++){
            char[] s = Integer.toString(n, i).toCharArray();
            for(int j = 0, k = s.length-1;j < k;j++,k--){
                if(s[j] != s[k])return false;
            }
        }
        return true;
    }
}
