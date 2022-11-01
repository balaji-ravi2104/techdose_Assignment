class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int ans[] = new int[nums.length - k + 1];
	Deque<Integer> q = new LinkedList<>();
    
    int i = 0;
    int j = 0;
    
    while(j < nums.length){
        // calculation
        if(q.size() == 0){
            q.add(nums[j]);
        }
        else{
            while(q.size() > 0 && q.peekLast() < nums[j]){
                q.removeLast();
            }
            q.add(nums[j]);
        }
        // now move j pointer
        if(j - i + 1 < k) j++;
        // if we hit the window size
        else if(j - i + 1 == k){
            // answer -> calculation;
            ans[i] = q.peek();
            // slide the window
            // calculation
            if(nums[i] == q.peek()){
                q.removeFirst();
            }
            // now slide the pointer
            i++;
            j++;
        }
    }
    return ans;
    }
}
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length*/
