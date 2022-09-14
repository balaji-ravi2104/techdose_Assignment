class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!Character.isLowerCase(ch)){
                if(st.empty()){
                    st.push(i);
                }
                else{
                    char top=s.charAt(st.peek());
                    if(ch==')' && top=='('){
                        st.pop();
                    }else{
                        st.push(i);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(!st.empty() && i==st.peek()){
                st.pop();
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}
/*  
Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
*/
