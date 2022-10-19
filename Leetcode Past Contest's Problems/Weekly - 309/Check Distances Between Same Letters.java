class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int first=s.indexOf(ch);
            int last=s.lastIndexOf(ch);
            int dist=last-first-1;
            if(distance[ch-97]!=dist){
                return false;
            }
        }
        return true;
    }
}
