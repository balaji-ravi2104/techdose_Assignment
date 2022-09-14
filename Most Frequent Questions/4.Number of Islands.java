class Solution {
    public int numIslands(char[][] grid) {
        int nr=grid.length;
        int nc=grid[0].length;
        int count=0;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int r,int c){
        int nr=grid.length;
        int nc=grid[0].length;
        if(r<0 || c<0 || r>=nr || c>=nc || grid[r][c]=='0'){
            return ;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
    }
}
