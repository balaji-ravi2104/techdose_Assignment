class Solution {
    public String largestGoodInteger(String num) {
        String[] arr={"000","111","222","333","444","555","666","777","888","999"};
        String ans="";
        for(int i=0;i<10;i++){
            if(num.contains(arr[i])){
                ans=arr[i];
            }
        }
        return ans;
    }
}
