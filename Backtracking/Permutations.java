class Solution {
    // Another one method is also there check submission
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        toFindPermutation(0,nums,list);
        return list;
    }
    
    public static void toFindPermutation(int ind,int[] arr,List<List<Integer>> list){
        if(ind==arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            
            list.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            toFindPermutation(ind+1,arr,list);
            swap(i,ind,arr);
        }
    }
    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
