class Solution {
    public String greatestLetter(String s) {
        for(char c='z';c>='a';c--){
            char lower=Character.toLowerCase(c);
            char upper=Character.toUpperCase(c);
            if(s.contains(lower+"") && s.contains(upper+""))
                return upper+"";
        }
        return "";
    }
}
