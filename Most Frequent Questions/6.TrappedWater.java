class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2)
            return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=0;
        int maxleft=height[0];
        for(int i=0;i<n;i++){
            left[i]=maxleft;
            maxleft=Math.max(height[i],maxleft);
        }
        right[n-1]=0;
        int maxright=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i]=maxright;
            maxright=Math.max(height[i],maxright);
        }
        int total=0;
        for(int i=1;i<n-1;i++){
            if(height[i]<left[i] && height[i]<right[i])
                total+=Math.min(left[i],right[i])-height[i];
        }
        return total;
    }
}
