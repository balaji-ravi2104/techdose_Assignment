class Solution {
    public int maximumGroups(int[] grades) {
        int total=0,c=0,n=grades.length;
        while(total+c+1<=n){
            total+=++c;
        }
        return c;
    }
}
