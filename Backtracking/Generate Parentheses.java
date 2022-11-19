class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans,new StringBuilder(),0,0,n);
        //System.out.println(ans);
        return ans;
    }
    public static void generate(List<String> ans,StringBuilder current,int open,int close,int max){
        if(current.length()==max*2){
            ans.add(current.toString());
            return;
        }
        
        if(open<max){
            current.append("(");
            generate(ans,current,open+1,close,max);
            current.deleteCharAt(current.length()-1);
        }
        
        if(close<open){
            current.append(")");
            generate(ans,current,open,close+1,max);
            current.deleteCharAt(current.length()-1);
        }
    }
}

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/
