class Solution {
    public int countPrefixes(String[] words, String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i+1);
            for(int j=0;j<words.length;j++){
                if(words[j].equals(str))
                    count++;
            }
        }
        return count;
    }
}
