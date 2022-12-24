class NumArray {
    int[] seg;
    int n;
    public void buildSegTree(int start_ind,int[] nums,int start,int end){
        if(start>end){
            return;
        }
        if(start==end){// Leaf node
            seg[start_ind]=nums[start]; // just assign start index to the start value
            return; 
        }
        int mid = start+(end-start)/2;
        buildSegTree(2*start_ind+1,nums,start,mid);// left call
        buildSegTree(2*start_ind+2,nums,mid+1,end);// right call
        seg[start_ind]=seg[2*start_ind+1]+seg[2*start_ind+2];
    }
    public NumArray(int[] nums) {
        n=nums.length;
        seg = new int[4*n+1];
        buildSegTree(0,nums,0,n-1);
    }
    public void updateVal(int start_ind,int start,int end,int pos,int newVal){
        if(start>pos || end<pos){ // No overLap
            return;
        }
        if(start==end){ // Total overLap
            seg[start_ind]=newVal;
            return;
        }
        int mid = start+(end-start)/2; // partial overLap
        updateVal(start_ind*2+1,start,mid,pos,newVal);
        updateVal(start_ind*2+2,mid+1,end,pos,newVal);
        seg[start_ind]=seg[start_ind*2+1]+seg[start_ind*2+2];
    }
    public void update(int index, int val) {
        updateVal(0,0,n-1,index,val);
    }
    public int rangeSum(int start_ind,int qs,int qe,int start,int end){
        if(qs>end || qe<start){
            return 0;
        }
        if(start>=qs && end<=qe){
            return seg[start_ind];
        }
        int mid = start+(end-start)/2;
        int leftSum = rangeSum(start_ind*2+1,qs,qe,start,mid);
        int rightSum = rangeSum(start_ind*2+2,qs,qe,mid+1,end);
        return leftSum+rightSum;
    }
    public int sumRange(int left, int right) {
        return rangeSum(0,left,right,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.
*/
