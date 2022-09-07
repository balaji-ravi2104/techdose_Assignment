class Solution {
    public int[] decode(int[] encoded) {
        int first=0;
        int n=encoded.length+1;
        for(int i=1;i<=n;i++){
            first^=i;
        }
        for(int i=1;i<n;i+=2){
            first^=encoded[i];
        }
        int[] arr =new int[n];
        arr[0]=first;
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]^encoded[i-1];
        }
        return arr;
    }
}