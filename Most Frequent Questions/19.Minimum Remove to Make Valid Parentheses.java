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
