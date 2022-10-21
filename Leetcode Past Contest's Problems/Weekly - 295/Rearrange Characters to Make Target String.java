class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] str = new int[26];
        int[] tag = new int[26];
        for(int i=0;i<s.length();i++){
            str[s.charAt(i)-'a']++;
        }
        for(int i=0;i<target.length();i++){
            tag[target.charAt(i)-'a']++;
        }
        int ans = s.length();
        for(int i=0;i<26;i++){
            if(tag[i]!=0) {
                ans = Math.min(ans,str[i]/tag[i]);
            }
        }
        return ans;
    }
}
