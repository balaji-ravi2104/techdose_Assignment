class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> l1 = new LinkedHashSet<>();
        Set<Integer> l2 = new LinkedHashSet<>();
        for(int i=0;i<nums1.length;i++){
            int flag=0;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                l1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            int flag=0;
            for(int j=0;j<nums1.length;j++){
                if(nums2[i]==nums1[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                l2.add(nums2[i]);
        }
        List<Integer> list1 = new ArrayList<>(l1);
        List<Integer> list2 = new ArrayList<>(l2);
        list.add(list1);
        list.add(list2);
        return list;
    }
}
