class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if(ch==')' && stack.peek()=='('){
                    stack.pop();
                }else if(ch=='}' && stack.peek()=='{'){
                    stack.pop();
                }else if(ch==']' && stack.peek()=='['){
                    stack.pop();
                }else{
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}


/* Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false */
