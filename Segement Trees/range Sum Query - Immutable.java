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
        buildSegTree(0,nums,0,n-1);//building tree;
    }
    public int rangeSum(int qs,int qe,int start_ind,int start,int end){
        if(qs>end || qe<start){
            return 0;// no overlaping
        }
        if(start>=qs && end<=qe){//total overlaping
            return seg[start_ind];
        }
        int mid = start+(end-start)/2; // partial overlaping
        int leftSum=rangeSum(qs,qe,start_ind*2+1,start,mid);// leftsum of the leftsub tree
        int rightSum=rangeSum(qs,qe,start_ind*2+2,mid+1,end);// rightsum of the rightsub tree
        return leftSum+rightSum; // return sum
    }
    public int sumRange(int left, int right) {
        return rangeSum(left,right,0,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive 
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
*/
