class Solution {
    public int minDeletion(int[] nums) {
        int ans=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(stack.size()%2==0)
                stack.add(nums[i]);
            else{
                if(stack.peek()==nums[i])
                    ans++;
                else
                    stack.add(nums[i]);
            }
        }
        return stack.size()%2==1?++ans:ans;
    }
}
