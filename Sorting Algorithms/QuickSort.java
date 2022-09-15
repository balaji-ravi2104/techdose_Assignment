import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc =new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    Quick(arr,0,n-1);
    PrintArray(arr,n);
  }
  public static void PrintArray(int[] arr,int n){
    for(int i=0;i<n;i++){
      System.out.print(arr[i]+" ");
    }
  }
  public static void Quick(int[] arr,int start,int end){
    if(start<end){
    int p=partition(arr,start,end); //p is partitioning index  
    Quick(arr,start,p-1);
    Quick(arr,p+1,end);
    }
  }
  public static int partition(int[] arr,int start,int end){
    int i=(start-1);
    int pivot=arr[end];// pivot element
    for(int j=start;j<=end-1;j++){
      if(arr[j]<pivot){ // If current element is smaller than the pivot  
        i++; //// increment index of smaller element
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
      }
    }
    int t=arr[i+1];
    arr[i+1]=arr[end];
    arr[end]=t;
    return i+1;
  }
}


/*  
Best Case --->	O(n*logn)
Average Case --->	O(n*logn)
Worst Case --->	O(n2)
*/
