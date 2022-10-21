class Solution {
    public int countAsterisks(String s) {
        int ans=0;
        String[] str=s.split("\\|");
        for(int i=0;i<str.length;i+=2){
            for(int j=0;j<str[i].length();j++){
                if(str[i].charAt(j)=='*')
                    ans++;
            }
        }
        return ans;
    }
}
