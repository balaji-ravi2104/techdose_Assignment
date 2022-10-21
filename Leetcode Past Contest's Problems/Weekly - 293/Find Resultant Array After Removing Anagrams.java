class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        String prev="";
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String current = String.valueOf(ch);
            if(!current.equals(prev))
            {
                list.add(words[i]);
                prev=current;
            }
        }
        return list;
    }
}
