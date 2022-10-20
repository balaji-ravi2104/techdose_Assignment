class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='*')
                stack.push(s.charAt(i));
            else
                stack.pop();
        }
        StringBuffer res=new StringBuffer();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        //res.reverse();
        return res.reverse().toString();
    }
}
