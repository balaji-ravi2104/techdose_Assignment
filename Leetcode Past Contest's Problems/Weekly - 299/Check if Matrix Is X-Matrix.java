class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row != col)
            return false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==j || (i+j)==(col-1))
                {
                    if(grid[i][j]==0)
                        return false;
                }
                else if(grid[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
