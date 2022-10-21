class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rank = new int[15];
        int[] card = new int[5];
        for(int i=0;i<5;i++){
            rank[ranks[i]]++;
            card[suits[i]-'a']++;
        }
        String ans="High Card";
        for(int i=0;i<5;i++){
            if(card[i]==5){
                ans="Flush";
                break;
            }
        }
        for(int i=0;i<14;i++){
            if(rank[i]>=3)
            {
                ans="Three of a Kind";
                return ans;
            }
            if(rank[i]==2){
                ans="Pair";
            }
        }
        return ans;
    }
}
