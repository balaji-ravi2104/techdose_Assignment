class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
       if(stack.pop()==min){
           min=stack.pop();
       } 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
