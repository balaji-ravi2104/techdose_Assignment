class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashSet<Character> hs = new HashSet<>();
        int j = 0;
        for(int i=0;i<s.length() && j<s.length();i++){
            while(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(j));
                j++;
            }
            hs.add(s.charAt(i));
            res = Math.max(res, hs.size());        
        }
        return res;
    }
}

/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. */
