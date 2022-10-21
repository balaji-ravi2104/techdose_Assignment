class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<items1.length;i++){
            map.put(items1[i][0],items1[i][1]);
        }
        for(int i=0;i<items2.length;i++){
            int index=items2[i][0];
            int val=items2[i][1];
            map.put(index,map.getOrDefault(index,0)+val);
        }
        for(var i:map.entrySet()){
            list.add(Arrays.asList(i.getKey(),i.getValue()));
        }
        return list;
    }
}
