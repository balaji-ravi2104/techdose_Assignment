class Solution {
    public int divisorSubstrings(int num, int k) {
        String str=String.valueOf(num);
        int count=0;
        for(int i=0;i<str.length()-k+1;i++){
            String sub = str.substring(i,i+k);
            int N=Integer.valueOf(sub);
            if(N!=0 && num%N==0){
                count++;
            }
        }
        return count;
    }
}
