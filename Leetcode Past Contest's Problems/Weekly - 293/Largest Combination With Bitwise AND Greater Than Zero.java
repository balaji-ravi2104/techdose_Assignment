class Solution {
    public int largestCombination(int[] candidates) {
        int res=0,curr=0;
        for(int i=1;i<=10000000;i<<=1){
            //System.out.println(i);
            curr=0;
            for(int x:candidates)
                if((x&i)>0)
                    curr++;
            res=Math.max(res,curr);
        }
        return res;
    }
}
