//TC-O(LogN)
class Solution {
    int[] seg;
    int n;
    public void buildTree(int start_ind,int start,int end,int[] arr){
        if(start>end){
            return;
        }

        if(start==end){
            seg[start_ind]=arr[start];
            return;
        }

        int mid=start+(end-start)/2;
        buildTree(start_ind*2+1,start,mid,arr);
        buildTree(start_ind*2+2,mid+1,end,arr);
        seg[start_ind]=seg[start_ind*2+1]^seg[start_ind*2+2];
    }
    public int xorValueOf(int qs,int qe,int start_ind,int start,int end){
        if(qs>end || qe<start){
            return 0;
        }

        if(start>=qs && end<=qe){
            return seg[start_ind];
        }
        int mid = start+(end-start)/2; // partial overlaping
        int leftSum=xorValueOf(qs,qe,start_ind*2+1,start,mid);// leftsum of the leftsub tree
        int rightSum=xorValueOf(qs,qe,start_ind*2+2,mid+1,end);// rightsum of the rightsub tree
        return leftSum^rightSum; 
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        n=arr.length;
        seg = new int[4*n+1];
        int[] ans = new int[queries.length];
        buildTree(0,0,n-1,arr);
        for(int i=0;i<queries.length;i++){
        ans[i]=xorValueOf(queries[i][0],queries[i][1],0,0,n-1);
        }
        return ans;
    }
}
/*
You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.

 

Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8] 
Explanation: 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
 

Constraints:

1 <= arr.length, queries.length <= 3 * 104
1 <= arr[i] <= 109
queries[i].length == 2
0 <= lefti <= righti < arr.length
*/
