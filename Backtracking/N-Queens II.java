class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        List<List<String>> list = new ArrayList<>();
        solve(0,board,leftRow,upperDiagonal,lowerDiagonal,list);
        //System.out.println(list.size());
        //return list.size();
        return count;
    }
    
    public void solve(int col,char[][] board,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal,List<List<String>> list){
        if(col==board.length){
            count++;
            return;
        }
        
        for(int row=0;row<board.length;row++){
            
            if(leftRow[row]==0 && upperDiagonal[board.length-1+col-row]==0 && lowerDiagonal[row+col]==0 ){
                board[row][col]='Q';
                leftRow[row]=1;
                upperDiagonal[board.length-1+col-row]=1;
                lowerDiagonal[row+col]=1;
                solve(col+1,board,leftRow,upperDiagonal,lowerDiagonal,list);
                board[row][col]='.';
                leftRow[row]=0;
                upperDiagonal[board.length-1+col-row]=0;
                lowerDiagonal[row+col]=0;
            }
        }
    }
}

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
*/
