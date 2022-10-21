class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map = new HashMap<>();
        int max=0;
        String ans="";
        for(int i=0;i<senders.length;i++){
            String[] arr = messages[i].split(" ");
            int len=arr.length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+len);
            if(map.get(senders[i])>max){
                max=map.get(senders[i]);
                ans=senders[i];
            }else if(map.get(senders[i])==max && ans.compareTo(senders[i])<0){
                ans=senders[i];
            }
        }
        return ans;
    }
}
