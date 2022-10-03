package Arrays.HomeWork;

import java.util.Arrays;
import java.util.Scanner;

public class CountingInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println(countInversions(arr));
        System.out.println(Arrays.toString(arr));
    }
    static int countInversions(int[] nums){
        return sort(nums,0,nums.length-1);
    }
    static int sort(int[] arr,int lo,int hi){
        int sum = 0;
       // System.out.println(Arrays.toString(arr));
        if(lo<hi){
            int mid = (lo+hi)>>1;
            sum+= sort(arr,lo,mid);
            sum+= sort(arr,mid+1,hi);
            //System.out.println(Arrays.toString(arr));
            sum+= merge(arr,lo,mid,hi);
        }

        //System.out.printf("lo=%d hi=%d sum=%d\n",lo,hi,sum);
        return sum;
    }
    static int merge(int[] arr,int lo,int mid,int hi){
        int[] newArr = new int[hi+1];
        int i=lo,j=mid+1,k=lo, inversions = 0;
        while(i<=mid && j<=hi){
            if(arr[i]<=arr[j])
                newArr[k++] = arr[i++];
            else{
                newArr[k++] = arr[j++];
                inversions+= (mid+1)-i;// length - i pointer
            }
        }
        while(i<=mid) newArr[k++] = arr[i++];
        while(j<=hi){
            newArr[k++] = arr[j++];
        }
        for(int index=lo;index<=hi;index++){
            arr[index]= newArr[index];
        }
        return inversions;
    }
}
