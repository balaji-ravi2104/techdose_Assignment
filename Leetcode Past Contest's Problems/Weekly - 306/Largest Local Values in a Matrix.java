class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int max=0,index=0;
        int[][] ans = new int[n-2][n-2];
        int[] arr=new int[(n-2) * (n-2)];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                max=toFindMax(i,j,grid);
                arr[index++]=max;
            }
        }
        int val=0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j]=arr[val];
                val++;
            }
        }
        return ans;
    }
    public int toFindMax(int row,int col,int[][] grid){
        int max=grid[row][col];
        for(int i=row;i<=row+2;i++){
            for(int j=col;j<=col+2;j++){
                max=Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
}
