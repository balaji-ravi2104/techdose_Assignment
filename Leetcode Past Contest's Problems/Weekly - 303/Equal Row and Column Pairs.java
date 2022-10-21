class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int count=0,ans=0;
        for(int i=0;i<n;i++){
            count=toFind(i,grid,n);
            ans+=count;
        }
        return ans;
    }
    public static int toFind(int row,int grid[][],int n){
          int count=0;
          for(int i=0;i<n;i++){
              int f=1;
              for(int j=0;j<n;j++){
                  if(grid[j][i]!=grid[row][j]){
                      f=0;
                      break;
                  }
              }
              if(f==1)
                  count++;
          }
          return count;
    } 
}
