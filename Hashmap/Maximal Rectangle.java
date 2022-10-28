class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        
        int[] height = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                height[i]=1;
            }
        }
        int result=LargerInLine(height);
        for(int i=1;i<matrix.length;i++){
            resetHeight(matrix,height,i);
            result=Math.max(result,LargerInLine(height));
        }
        return result;
    }
    public void resetHeight(char[][] matrix,int[] height,int ind){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[ind][i]=='1'){
                height[i]+=1;
            }else{
                height[i]=0;
            }
        }
    }
    
    public static int LargerInLine(int[] height){
        if(height==null || height.length==0)
            return 0;
     Stack<Integer> s = new Stack<>();
     int len=height.length;
     int max=0;
     for(int i=0;i<=len;i++){
         int h= i==len ? 0 : height[i];
         if(s.isEmpty() || h>=height[s.peek()])
             s.push(i);
         else{
             int top=s.pop();
             max=Math.max(max,height[top]*(s.isEmpty() ? i:i-1-s.peek()));
             i--;
         }
     }
        return max;
    }
}
/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
*/
