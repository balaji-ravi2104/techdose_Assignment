class Solution {
    public List<List<String>> solveNQueens(int n) {
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
        return list;
    }
    
    public static void solve(int col,char[][] board,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal,List<List<String>> list){
        if(col==board.length){
            list.add(construct(board));
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
    
    public static List<String> construct(char[][] board){
        List<String> list = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String str = new String(board[i]);
            list.add(str);
        }
        return list;
    }
}

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
*/
