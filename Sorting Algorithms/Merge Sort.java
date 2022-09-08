import java.util.*;
public class Main{
  public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  int n=sc.nextInt();
  int[] arr = new int[n];
  for(int i=0;i<n;i++){
  arr[i]=sc.nextInt();
  }
  mergeSort(arr,0,n-1);
  for(int i=0;i<n;i++){
  System.out.print(arr[i]+" ");
  }
  }
  public static void mergeSort(int[] arr,int low,int high){
  if(high==low){
  return ;
  }
  int mid=low+(high-low)/2;
  mergeSort(arr,low,mid);
  mergeSort(arr,mid+1,high);
  merge(arr,high,mid,low);
  }
  public static void merge(int[] arr,int high,int mid,int low){
     int i=low,j=mid+1;
     int temp[]=new int [high+1];
     int k=low;
     while(i<=mid && j<=high){
     if(arr[i]>arr[j]){
       temp[k++]=arr[j];
       j++;
     }else{
        temp[k++]=arr[i];
        i++;
     }
   }
     while(i<=mid){
     temp[k++]=arr[i++];
     }
     while(j<=high){
     temp[k++]=arr[j++];
     }
     for(int ctr=low;ctr<=high;ctr++){
     arr[ctr]=temp[ctr];
     }
}
}


Time Complexity:
BC : O(NlogN)
WC : O(NlogN)
AC : O(NlogN)
